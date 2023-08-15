package luke.algorithm.practice.tree;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void buildMinimalBinarySearchTreeTest1(){
        int[] a = {1,2,3,4,5,6,7,8,9};
        BinaryTreeNode root = BinaryTree.buildMinimalBinarySearchTree(a);
        assertEquals(5, root.value);
        assertEquals(3, root.left.value);
        assertEquals(2, root.left.left.value);
        assertEquals(1, root.left.left.left.value);
        assertEquals(4, root.left.right.value);
        assertEquals(8, root.right.value);
        assertEquals(7, root.right.left.value);
        assertEquals(6, root.right.left.left.value);
        assertEquals(9, root.right.right.value);
    }

    @Test
    public void buildMinimalBinarySearchTreeTest2(){
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        BinaryTreeNode root = BinaryTree.buildMinimalBinarySearchTree(a);
        assertEquals(6, root.value);
        assertEquals(3, root.left.value);
        assertEquals(2, root.left.left.value);
        assertEquals(1, root.left.left.left.value);
        assertEquals(5, root.left.right.value);
        assertEquals(4, root.left.right.left.value);
        assertEquals(9, root.right.value);
        assertEquals(8, root.right.left.value);
        assertEquals(7, root.right.left.left.value);
        assertEquals(10, root.right.right.value);
    }

    @Test
    public void buildMinimalBinarySearchTreeTest3(){
        int[] a = {1,2,3,4,5,6,7,8,9,10,11};
        BinaryTreeNode root = BinaryTree.buildMinimalBinarySearchTree(a);
        assertEquals(6, root.value);
        assertEquals(3, root.left.value);
        assertEquals(2, root.left.left.value);
        assertEquals(1, root.left.left.left.value);
        assertEquals(5, root.left.right.value);
        assertEquals(4, root.left.right.left.value);
        assertEquals(9, root.right.value);
        assertEquals(8, root.right.left.value);
        assertEquals(7, root.right.left.left.value);
        assertEquals(11, root.right.right.value);
        assertEquals(10, root.right.right.left.value);
    }

    @Test
    public void getDepthListTest1(){
        int[] a = {1,2,3,4,5,6,7,8,9,10,11};
        BinaryTreeNode root = BinaryTree.buildMinimalBinarySearchTree(a);
        ArrayList<ArrayList<BinaryTreeNode>> result = BinaryTree.getDepthList(root);
        assertEquals(4, result.size());
        int[] d0 = {6};
        assertArrayEquals(d0, result.get(0).stream().mapToInt(n -> n.value).toArray());
        int[] d1 = {3, 9};
        assertArrayEquals(d1, result.get(1).stream().mapToInt(n -> n.value).toArray());
        int[] d2 = {2, 5, 8, 11};
        assertArrayEquals(d2, result.get(2).stream().mapToInt(n -> n.value).toArray());
        int[] d3 = {1, 4, 7, 10};
        assertArrayEquals(d3, result.get(3).stream().mapToInt(n -> n.value).toArray());
    }

    @Test
    public void getDepthListTest2(){
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode left1 = new BinaryTreeNode(2);
        BinaryTreeNode right1 = new BinaryTreeNode(7);
        root.setLeft(left1);
        root.setRight(right1);
        BinaryTreeNode left2 = new BinaryTreeNode(3);
        BinaryTreeNode right2 = new BinaryTreeNode(8);
        left1.setLeft(left2);
        left1.setRight(right2);
        BinaryTreeNode left3 = new BinaryTreeNode(4);
        BinaryTreeNode right3 = new BinaryTreeNode(10);
        BinaryTreeNode right3b = new BinaryTreeNode(9);
        left2.setLeft(left3);
        left2.setRight(right3);
        right2.setRight(right3b);
        BinaryTreeNode left4 = new BinaryTreeNode(5);
        BinaryTreeNode right4 = new BinaryTreeNode(13);
        BinaryTreeNode right4b = new BinaryTreeNode(11);
        left3.setLeft(left4);
        left3.setRight(right4);
        right3.setRight(right4b);
        BinaryTreeNode left5 = new BinaryTreeNode(6);
        BinaryTreeNode right5b = new BinaryTreeNode(14);
        BinaryTreeNode right5c = new BinaryTreeNode(12);
        left4.setLeft(left5);
        right4.setRight(right5b);
        right4b.setRight(right5c);
        BinaryTreeNode node6 = new BinaryTreeNode(15);
        BinaryTreeNode node7 = new BinaryTreeNode(16);
        right5b.setRight(node6);
        node6.setRight(node7);

        ArrayList<ArrayList<BinaryTreeNode>> result = BinaryTree.getDepthList(root);
        assertEquals(8, result.size());
        int[] d0 = {1};
        assertArrayEquals(d0, result.get(0).stream().mapToInt(n -> n.value).toArray());
        int[] d1 = {2, 7};
        assertArrayEquals(d1, result.get(1).stream().mapToInt(n -> n.value).toArray());
        int[] d2 = {3, 8};
        assertArrayEquals(d2, result.get(2).stream().mapToInt(n -> n.value).toArray());
        int[] d3 = {4, 10, 9};
        assertArrayEquals(d3, result.get(3).stream().mapToInt(n -> n.value).toArray());
        int[] d4 = {5, 13, 11};
        assertArrayEquals(d4, result.get(4).stream().mapToInt(n -> n.value).toArray());
        int[] d5 = {6, 14, 12};
        assertArrayEquals(d5, result.get(5).stream().mapToInt(n -> n.value).toArray());
        int[] d6 = {15};
        assertArrayEquals(d6, result.get(6).stream().mapToInt(n -> n.value).toArray());
        int[] d7 = {16};
        assertArrayEquals(d7, result.get(7).stream().mapToInt(n -> n.value).toArray());
    }

}