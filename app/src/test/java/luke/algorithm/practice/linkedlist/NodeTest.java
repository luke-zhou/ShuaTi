package luke.algorithm.practice.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    @Test
    public void removeDupNoDups() {
        int[] a = {1, 2, 3, 4, 5};
        Node testNode = Node.create(a);
        testNode.removeDup();
        assertEquals(5, testNode.size());
        assertArrayEquals(a, testNode.toArray());
    }

    @Test
    public void removeDupDups() {
        int[] a = {1, 2, 2, 4, 5};
        Node testNode = Node.create(a);
        testNode.removeDup();
        assertEquals(4, testNode.size());
        int[] expected = {1, 2, 4, 5};
        assertArrayEquals(expected, testNode.toArray());
    }

    @Test
    public void removeDupMultiDups() {
        int[] a = {2, 2, 2, 2, 2};
        Node testNode = Node.create(a);
        testNode.removeDup();
        assertEquals(1, testNode.size());
        int[] expected = {2};
        assertArrayEquals(expected, testNode.toArray());
    }

    @Test
    public void lastKthIter() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        Node testNode = Node.create(a);
        assertEquals(8, testNode.lastKth(1).data);
        assertEquals(7, testNode.lastKth(2).data);
        assertEquals(6, testNode.lastKth(3).data);
        assertEquals(1, testNode.lastKth(8).data);
    }

    @Test
    public void lastKthRecursive() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        Node testNode = Node.create(a);
        assertEquals(8, testNode.lastKth2(1).data);
        assertEquals(7, testNode.lastKth2(2).data);
        assertEquals(6, testNode.lastKth2(3).data);
        assertEquals(1, testNode.lastKth2(8).data);
    }

    @Test
    public void remove() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        Node list = Node.create(a);
        Node n = list.next.next;
        list.remove(n);
        int[] expected = {1, 2, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, list.toArray());
        n = list.next.next;
        list.remove(n);
        int[] expected2 = {1, 2, 5, 6, 7, 8};
        assertArrayEquals(expected2, list.toArray());
    }

    @Test
    public void partition() {
        int[] a = {3, 5, 8, 5, 10, 2, 1};
        Node list = Node.create(a);
        Node result = list.partition(5);
        int[] expected = {3, 2, 1, 5, 8, 5, 10};
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void sumReverseSameLength() {
        int[] a = {7, 1, 6};
        int[] b = {5, 9, 2};
        Node nodeA = Node.create(a);
        Node nodeB = Node.create(b);
        Node result = Node.sumReverse(nodeA, nodeB);
        int[] expected = {2, 1, 9};
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void sumReverseDiffLength() {
        int[] a = {7, 1, 6, 2, 1, 2, 3};
        int[] b = {5, 9, 2, 8};
        Node nodeA = Node.create(a);
        Node nodeB = Node.create(b);
        Node result = Node.sumReverse(nodeA, nodeB);
        int[] expected = {2, 1, 9, 0, 2, 2, 3};
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void sumForwardSameLength() {
        int[] a = {6, 1, 7};
        int[] b = {2, 9, 5};
        Node nodeA = Node.create(a);
        Node nodeB = Node.create(b);
        Node result = Node.sumForward(nodeA, nodeB);
        int[] expected = {9, 1, 2};
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void sumForwardDiffLength() {
        int[] a = {3, 2, 1, 2, 6, 1, 7};
        int[] b = {8, 2, 9, 5};
        Node nodeA = Node.create(a);
        Node nodeB = Node.create(b);
        Node result = Node.sumForward(nodeA, nodeB);
        int[] expected = {3, 2, 2, 0, 9, 1, 2};
        assertArrayEquals(expected, result.toArray());
    }
}
