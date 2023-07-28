package luke.algorithm.practice.linkedlist;
import org.junit.Test;
import static org.junit.Assert.*;
public class NodeTest {
    @Test
    public void removeDupNoDups() {
        int[] a = {1,2,3,4,5};
        Node testNode = Node.create(a);
        testNode.removeDup();
        assertEquals(5, testNode.size());
        assertArrayEquals(a, testNode.toArray());
    }

    @Test
    public void removeDupDups() {
        int[] a = {1,2,2,4,5};
        Node testNode = Node.create(a);
        testNode.removeDup();
        assertEquals(4, testNode.size());
        int[] expected = {1,2,4,5};
        assertArrayEquals(expected, testNode.toArray());
    }

    @Test
    public void removeDupMultiDups() {
        int[] a = {2,2,2,2,2};
        Node testNode = Node.create(a);
        testNode.removeDup();
        assertEquals(1, testNode.size());
        int[] expected = {2};
        assertArrayEquals(expected, testNode.toArray());
    }
}
