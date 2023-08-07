package luke.algorithm.practice.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackSetTest {
    @Test
    public void peakTest() {
        StackSet s = new StackSet();
        s.push(5);
        assertEquals(5, s.peek());
        s.push(6);
        assertEquals(6, s.peek());
        s.push(3);
        assertEquals(3, s.peek());
        s.push(7);
        assertEquals(7, s.peek());
        int result = s.pop();
        assertEquals(3, s.peek());
        assertEquals(7, result);
        result = s.pop();
        assertEquals(6, s.peek());
        assertEquals(3, result);
        result = s.pop();
        assertEquals(5, s.peek());
        assertEquals(6, result);
        result = s.pop();
        assertEquals(5, result);
    }

    @Test
    public void popAt() {
        StackSet s = new StackSet();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);
        s.push(9);

        int result = s.popAt(0);
        assertEquals(3, result);
        result = s.popAt(1);
        assertEquals(6, result);
        result = s.popAt(2);
        assertEquals(9, result);
    }

}