package luke.algorithm.practice.tree;

public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode parent;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public void setParent(BinaryTreeNode parent) {
        this.parent = parent;
    }
}
