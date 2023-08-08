package luke.algorithm.practice.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortedStackTest {
    @Test
    public void sortedStackTest(){
        SortedStack s = new SortedStack();
        s.push(3);
        s.push(1);
        s.push(4);
        s.push(1);
        s.push(5);
        s.push(9);
        s.push(2);
        s.push(6);
        assertEquals(1, (int)s.peek());
        assertEquals(1, (int)s.pop());
        assertEquals(1, (int)s.pop());
        assertEquals(2, (int)s.pop());
        assertEquals(3, (int)s.pop());
        assertEquals(4, (int)s.pop());
        assertEquals(5, (int)s.pop());
        assertEquals(6, (int)s.pop());
        assertEquals(9, (int)s.pop());
    }
}