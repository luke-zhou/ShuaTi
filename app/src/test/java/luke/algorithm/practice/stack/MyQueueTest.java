package luke.algorithm.practice.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueueTest {
    @Test
    public void sizeTest(){
        MyQueue q = new MyQueue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        assertEquals(6, q.size());
    }

    @Test
    public void isEmptyTest(){
        MyQueue q = new MyQueue();
        assertTrue(q.isEmpty());
        q.add(1);
        assertFalse(q.isEmpty());
    }

    @Test
    public void removeTest(){
        MyQueue q = new MyQueue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        assertEquals(1, q.remove());
        assertEquals(2, q.remove());
        assertEquals(3, q.remove());
        q.add(7);
        q.add(8);
        q.add(9);
        assertEquals(4, q.remove());
        assertEquals(5, q.remove());
        assertEquals(6, q.remove());
        assertEquals(7, q.remove());
        assertEquals(8, q.remove());
        assertEquals(9, q.remove());
    }

    @Test
    public void peekTest(){
        MyQueue q = new MyQueue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        assertEquals(1, q.peek());
        q.add(7);
        q.add(8);
        q.add(9);
        assertEquals(1, q.peek());
    }

}