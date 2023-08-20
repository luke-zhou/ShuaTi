package luke.algorithm.practice.tree;

import org.checkerframework.checker.units.qual.A;
import org.javatuples.Pair;
import org.javatuples.Tuple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BinaryTree {

    // input array is sorted asc
    public static BinaryTreeNode buildMinimalBinarySearchTree(int[] values) {
        return buildMinimalBinarySearchTree(values, 0, values.length);
    }

    public static BinaryTreeNode buildBinarySearchTree(int[] values) {
        BinaryTreeNode root = new BinaryTreeNode(values[0]);
        for (int i = 1; i < values.length; i++) {
            BinaryTreeNode parent = root;
            BinaryTreeNode target = values[i] <= parent.value ? parent.left : parent.right;
            while(target != null){
                parent = target;
                target = values[i] <= parent.value ? parent.left : parent.right;
            }
            BinaryTreeNode node = new BinaryTreeNode(values[i]);
            node.setParent(parent);
            if(values[i] <= parent.value){
                parent.left = node;
            }else {
                parent.right = node;
            }
        }
        return root;
    }

    public static void display(BinaryTreeNode node){
        HashMap<BinaryTreeNode, Integer> space = new HashMap<>();
        calculateSpace(node, space);
//        for (Map.Entry<BinaryTreeNode, Integer> entry : space.entrySet()) {
//            System.out.println(entry.getKey().value + ": " + entry.getValue());
//        }
        ArrayList<ArrayList<BinaryTreeNode>> depthLists = getDepthList(node);
        for(ArrayList<BinaryTreeNode> list: depthLists){
            StringBuilder sbLine = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            sbLine.append("|");
            sb.append(list.get(0).value);
            for(int i = 1; i < list.size(); i++){
                int count = space.get(list.get(i-1))*5-1;
                String link = list.get(i).parent == list.get(i-1).parent ? "-" : " ";
                sbLine.append(link.repeat(count));
                sbLine.append("|");
                sb.append(" ".repeat(count));
                sb.append(list.get(i).value);
            }
            System.out.println(sbLine);
            System.out.println(sb);

        }

    }
    private static int calculateSpace(BinaryTreeNode node, HashMap<BinaryTreeNode, Integer> map){
        if(node == null) return 0;

        int space = calculateSpace(node.left, map) + calculateSpace(node.right, map);
        space = space == 0 ? 1 : space;
        map.put(node, space);
        return space;
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
        } else {
            int middleIndex = (end - start) / 2 + start;
            root = new BinaryTreeNode(values[middleIndex]);
            root.setLeft(buildMinimalBinarySearchTree(values, start, middleIndex));
            root.setRight(buildMinimalBinarySearchTree(values, middleIndex + 1, end));
        }

        return root;
    }

    public static ArrayList<ArrayList<BinaryTreeNode>> getDepthList(BinaryTreeNode root) {
        ArrayList<ArrayList<BinaryTreeNode>> result = new ArrayList<>();
        ArrayList<Pair<BinaryTreeNode, Integer>> queue = new ArrayList<>();
        queue.add(Pair.with(root, 0));
        while (!queue.isEmpty()) {
            Pair<BinaryTreeNode, Integer> p = queue.remove(0);
            int depth = p.getValue1();
            BinaryTreeNode node = p.getValue0();
            if (depth < result.size()) {
                result.get(depth).add(node);
            } else {
                ArrayList<BinaryTreeNode> list = new ArrayList<>();
                list.add(node);
                result.add(list);
            }
            if (node.left != null) {
                queue.add(Pair.with(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.add(Pair.with(node.right, depth + 1));
            }
        }
        return result;
    }

    public static boolean isBalanced(BinaryTreeNode root) {
        return heightAndBalanced(root).getValue1();
    }

    private static Pair<Integer, Boolean> heightAndBalanced(BinaryTreeNode node) {
        if (node == null) return new Pair<>(0, true);
        Pair<Integer, Boolean> left = heightAndBalanced(node.left);
        Pair<Integer, Boolean> right = heightAndBalanced(node.right);
        int height = Math.max(left.getValue0(), right.getValue0()) + 1;
        boolean balanced = left.getValue1() && right.getValue1() && Math.abs(left.getValue0() - right.getValue0()) <= 1;
        return new Pair<>(height, balanced);
    }

    public static boolean isBST(BinaryTreeNode root) {
        return isBST(root, null, null);
    }

    private static boolean isBST(BinaryTreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if (min != null && node.value < min) return false;
        if (max != null && node.value >= max) return false;

        return isBST(node.left, min, node.value) && isBST(node.right, node.value, max);

    }

    public static void inOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }
}
