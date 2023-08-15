package luke.algorithm.practice.tree;

import org.checkerframework.checker.units.qual.A;
import org.javatuples.Pair;
import org.javatuples.Tuple;

import java.util.ArrayList;

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

    public static ArrayList<ArrayList<BinaryTreeNode>> getDepthList(BinaryTreeNode root){
        ArrayList<ArrayList<BinaryTreeNode>> result = new ArrayList<>();
        ArrayList<Pair<BinaryTreeNode, Integer>> queue = new ArrayList<>();
        queue.add(Pair.with(root, 0));
        while(!queue.isEmpty()){
            Pair<BinaryTreeNode, Integer> p = queue.remove(0);
            int depth = p.getValue1();
            BinaryTreeNode node = p.getValue0();
            if (depth < result.size()){
                result.get(depth).add(node);
            }else{
                ArrayList<BinaryTreeNode> list = new ArrayList<>();
                list.add(node);
                result.add(list);
            }
            if(node.left != null){
                queue.add(Pair.with(node.left, depth+1));
            }
            if(node.right != null){
                queue.add(Pair.with(node.right, depth+1));
            }
        }
        return result;
    }

}
