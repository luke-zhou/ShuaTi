package luke.algorithm.practice.tree;

import org.junit.Test;

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

}