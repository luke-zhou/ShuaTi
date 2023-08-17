package luke.algorithm.practice.tree;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void buildMinimalBinarySearchTreeTest1(){
        BinaryTreeNode root = BinaryTree.buildMinimalBinarySearchTree(new int[]{1,2,3,4,5,6,7,8,9});
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
        BinaryTreeNode root = BinaryTree.buildMinimalBinarySearchTree(new int[]{1,2,3,4,5,6,7,8,9,10});
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
        BinaryTreeNode root = BinaryTree.buildMinimalBinarySearchTree(new int[]{1,2,3,4,5,6,7,8,9,10,11});
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
        BinaryTreeNode root = BinaryTree.buildMinimalBinarySearchTree(new int[]{1,2,3,4,5,6,7,8,9,10,11});
        ArrayList<ArrayList<BinaryTreeNode>> result = BinaryTree.getDepthList(root);
        assertEquals(4, result.size());
        assertArrayEquals(new int[]{6}, result.get(0).stream().mapToInt(n -> n.value).toArray());
        assertArrayEquals(new int[]{3, 9}, result.get(1).stream().mapToInt(n -> n.value).toArray());
        assertArrayEquals(new int[]{2, 5, 8, 11}, result.get(2).stream().mapToInt(n -> n.value).toArray());
        assertArrayEquals(new int[]{1, 4, 7, 10}, result.get(3).stream().mapToInt(n -> n.value).toArray());
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
        assertArrayEquals(new int[]{1}, result.get(0).stream().mapToInt(n -> n.value).toArray());
        assertArrayEquals(new int[]{2, 7}, result.get(1).stream().mapToInt(n -> n.value).toArray());
        assertArrayEquals(new int[]{3, 8}, result.get(2).stream().mapToInt(n -> n.value).toArray());
        assertArrayEquals(new int[]{4, 10, 9}, result.get(3).stream().mapToInt(n -> n.value).toArray());
        assertArrayEquals(new int[]{5, 13, 11}, result.get(4).stream().mapToInt(n -> n.value).toArray());
        assertArrayEquals(new int[]{6, 14, 12}, result.get(5).stream().mapToInt(n -> n.value).toArray());
        assertArrayEquals(new int[]{15}, result.get(6).stream().mapToInt(n -> n.value).toArray());
        assertArrayEquals(new int[]{16}, result.get(7).stream().mapToInt(n -> n.value).toArray());
    }

    @Test
    public void isBalanced1() {
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

        assertFalse(BinaryTree.isBalanced(root));
    }

    @Test
    public void isBalanced2() {
        BinaryTreeNode root = BinaryTree.buildMinimalBinarySearchTree(new int[]{1,2,3,4,5,6,7,8,9,10,11});

        assertTrue(BinaryTree.isBalanced(root));
    }
}