package luke.algorithm.practice.stack;

import luke.algorithm.practice.linkedlist.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackWithMinTest {
    @Test
    public void minTest1() {
        StackWithMin s = new StackWithMin();
        s.push(5);
        assertEquals(5, s.min());
        s.push(6);
        assertEquals(5, s.min());
        s.push(3);
        assertEquals(3, s.min());
        s.push(7);
        assertEquals(3, s.min());
        s.pop();
        assertEquals(3, s.min());
        s.pop();
        assertEquals(5, s.min());
        s.pop();
        assertEquals(5, s.min());
    }

    @Test
    public void minTest2() {
        StackWithMin s = new StackWithMin();
        s.push(5);
        assertEquals(5, s.min());
        s.push(6);
        assertEquals(5, s.min());
        s.push(7);
        assertEquals(5, s.min());
        s.push(1);
        assertEquals(1, s.min());
        s.push(2);
        assertEquals(1, s.min());
        s.push(1);
        assertEquals(1, s.min());
        s.push(2);
        assertEquals(1, s.min());
        s.pop();
        assertEquals(1, s.min());
        s.pop();
        assertEquals(1, s.min());
        s.pop();
        assertEquals(1, s.min());
        s.pop();
        assertEquals(5, s.min());
    }

}