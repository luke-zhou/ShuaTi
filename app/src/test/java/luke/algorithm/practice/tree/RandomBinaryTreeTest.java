package luke.algorithm.practice.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomBinaryTreeTest {

    @Test
    public void build(){
        RandomBinaryTree tree = RandomBinaryTree.build(new int[]{1,2,3});
        BinaryTree.display(tree.root);
        assertEquals(3, tree.size);
        tree = RandomBinaryTree.build(new int[]{1,2,3,4});
        BinaryTree.display(tree.root);
        assertEquals(4, tree.size);
        tree = RandomBinaryTree.build(new int[]{1,2,3,4,5});
        BinaryTree.display(tree.root);
        assertEquals(5, tree.size);
        tree = RandomBinaryTree.build(new int[]{1,2,3,4,5,6});
        BinaryTree.display(tree.root);
        assertEquals(6, tree.size);
        tree = RandomBinaryTree.build(new int[]{1,2,3,4,5,6,7});
        BinaryTree.display(tree.root);
        assertEquals(7, tree.size);
        tree = RandomBinaryTree.build(new int[]{1,2,3,4,5,6,7,8});
        BinaryTree.display(tree.root);
        assertEquals(8, tree.size);
    }

    @Test
    public void getNode(){
        RandomBinaryTree tree = RandomBinaryTree.build(new int[]{1,2,3,4,5,6,7,8});
        assertEquals(8, tree.getNode(8).value);
        assertEquals(7, tree.getNode(7).value);
        assertEquals(6, tree.getNode(6).value);
        assertEquals(5, tree.getNode(5).value);
        assertEquals(4, tree.getNode(4).value);
        assertEquals(3, tree.getNode(3).value);
        assertEquals(2, tree.getNode(2).value);
        assertEquals(1, tree.getNode(1).value);
    }

}