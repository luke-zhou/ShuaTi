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

    @Test
    public void lastKthIter() {
        int[] a = {1,2,3,4,5,6,7,8};
        Node testNode = Node.create(a);
        assertEquals(8, testNode.lastKth(1).data);
        assertEquals(7, testNode.lastKth(2).data);
        assertEquals(6, testNode.lastKth(3).data);
        assertEquals(1, testNode.lastKth(8).data);
    }

    @Test
    public void lastKthRecursive() {
        int[] a = {1,2,3,4,5,6,7,8};
        Node testNode = Node.create(a);
        assertEquals(8, testNode.lastKth2(1).data);
        assertEquals(7, testNode.lastKth2(2).data);
        assertEquals(6, testNode.lastKth2(3).data);
        assertEquals(1, testNode.lastKth2(8).data);
    }

    @Test
    public void remove() {
        int[] a = {1,2,3,4,5,6,7,8};
        Node list = Node.create(a);
        Node n = list.next.next;
        list.remove(n);
        int[] expected = {1,2,4,5,6,7,8};
        assertArrayEquals(expected, list.toArray());
        n = list.next.next;
        list.remove(n);
        int[] expected2 = {1,2,5,6,7,8};
        assertArrayEquals(expected2, list.toArray());
    }
}
