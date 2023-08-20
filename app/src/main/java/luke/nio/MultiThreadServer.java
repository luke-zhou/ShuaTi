package luke.nio;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MultiThreadServer {

    public static void main(String args[]) throws Exception {
        Thread.currentThread().setName("Boss");
        Selector boss = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        SelectionKey bossKey = ssc.register(boss, 0, null);
        bossKey.interestOps(SelectionKey.OP_ACCEPT);
        ssc.bind(new InetSocketAddress(7999));

        Worker[] workers = new Worker[4];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Worker("worker-" + i);
        }

        AtomicInteger index = new AtomicInteger();

        while (true) {
            boss.select();
            Iterator<SelectionKey> iter = boss.selectedKeys().iterator();

            while (iter.hasNext()) {
                SelectionKey key = iter.next();
                iter.remove();
                if (key.isAcceptable()) {
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel sc = channel.accept();
                    sc.configureBlocking(false);

                    log.debug("connected... {}", sc.getRemoteAddress());
                    log.debug("before register {}", sc.getRemoteAddress());
                    workers[index.getAndIncrement() % workers.length].register(sc);
                    log.debug("after register {}", sc.getRemoteAddress());

                }
            }
        }
    }
}
