package luke.algorithm.practice.tree;

public class BinaryTree {

    // input array is sorted asc
    public static BinaryTreeNode buildMinimalBinarySearchTree(int[] values) {
        return buildMinimalBinarySearchTree(values, 0, values.length);
    }

    private static BinaryTreeNode buildMinimalBinarySearchTree(int[] values, int start, int end) {
        int size = end - start;
        BinaryTreeNode root = null;
        if (size == 1) {
            root = new BinaryTreeNode(values[start]);
        } else if (size == 2) {
            root = new BinaryTreeNode(values[start + 1]);
            BinaryTreeNode leaf = new BinaryTreeNode(values[start]);
            root.setLeft(leaf);
        } else if (size == 3) {
            root = new BinaryTreeNode(values[start + 1]);
            BinaryTreeNode left = new BinaryTreeNode(values[start]);
            BinaryTreeNode right = new BinaryTreeNode(values[start + 2]);
            root.setLeft(left);
            root.setRight(right);
        }else{
            int middleIndex = (end - start) / 2 + start;
            root = new BinaryTreeNode(values[middleIndex]);
            root.setLeft(buildMinimalBinarySearchTree(values, start, middleIndex));
            root.setRight(buildMinimalBinarySearchTree(values, middleIndex + 1, end));
        }

        return root;
    }
}
