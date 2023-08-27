package luke.algorithm.practice.tree;

import java.util.Random;
import java.util.Stack;

public class RandomBinaryTree {
    public BinaryTreeNode root;
    public int size;

    public RandomBinaryTree() {
        root = null;
        size = 0;
    }

    public static RandomBinaryTree build(int[] numbers) {
        RandomBinaryTree tree = new RandomBinaryTree();
        for (int n : numbers) {
            tree.insert(n);
        }
        return tree;
    }

    public BinaryTreeNode getRandomNode(){
        Random r = new Random();
        int pick = r.nextInt(this.size) +1;
        return getNode(pick);
    }

    public BinaryTreeNode getNode(int index){
        Stack<Boolean> s = new Stack<>();
        while (index > 1) {
            boolean left = index % 2 == 0;
            s.push(left);
            index /= 2;
        }
        BinaryTreeNode pickNode = root;
        while (!s.isEmpty()) {
            boolean left = s.pop();
            pickNode = left ? pickNode.left : pickNode.right;
        }
        return pickNode;
    }

    public void insert(int n) {

        BinaryTreeNode node = new BinaryTreeNode(n);
        this.size += 1;
        if (this.size == 1) {
            this.root = node;
            return;
        }

        Stack<Boolean> s = new Stack<>();
        int index = this.size;
        while (index > 1) {
            boolean left = index % 2 == 0;
            s.push(left);
            index /= 2;
        }
        BinaryTreeNode current = root;

        while (s.size() > 1) {
            boolean left = s.pop();
            current = left ? current.left : current.right;
        }

        if (s.pop()) {
            current.left = node;
        } else {
            current.right = node;
        }
    }
}
