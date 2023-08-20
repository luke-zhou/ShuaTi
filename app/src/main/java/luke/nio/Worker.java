package luke.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class Worker implements Runnable{
    private Thread thread;
    public volatile Selector worker;
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    private volatile boolean start = false;

    private ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<>();

    public void register(SocketChannel sc) throws IOException {
        if (!this.start) {
            this.thread = new Thread(this, this.name);
            this.worker = Selector.open();
            this.thread.start();
            this.start = true;
        }

//        this.queue.add(() -> {
//            try {
//                sc.register(this.selector, SelectionKey.OP_READ, null);
//            } catch (ClosedChannelException e) {
//                throw new RuntimeException(e);
//            }
//        });

        sc.register(this.worker, SelectionKey.OP_READ, null);

        this.worker.wakeup();

    }

    @Override
    public void run() {
        while (true) {
            try {
                this.worker.select();
                Iterator<SelectionKey> iter = this.worker.selectedKeys().iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    iter.remove();
                    if (key.isReadable()) {
                        ByteBuffer buffer = ByteBuffer.allocate(16);
                        SocketChannel channel = (SocketChannel) key.channel();
                        int readCount = channel.read(buffer);
                        if(readCount >0) {
                            buffer.flip();
                            ByteBufferUtil.debugAll(buffer);
                            buffer.clear();
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
