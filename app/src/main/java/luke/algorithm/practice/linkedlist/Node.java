package luke.algorithm.practice.linkedlist;

import org.javatuples.Pair;

import java.util.HashSet;

public class Node {
    Node next = null;
    public int data;

    public Node(int d) {
        data = d;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
    }

    public static Node create(int[] a){
        Node preHead = new Node(0);
        Node current = preHead;
        for (int i : a){
            Node n = new Node(i);
            current.next = n;
            current = n;
        }

        return preHead.next;
    }

    public int size(){
        int size = 1;
        Node current = this.next;
        while (current != null){
            size++;
            current = current.next;
        }

        return size;
    }

    public int[] toArray(){
        int size = size();
        int[] a = new int[size];
        int i = 0;
        Node current = this;
        while (current != null){
            a[i++] = current.data;
            current = current.next;
        }

        return a;
    }

    /*
     * Remove Dups:
     * Write code to remove duplicates from an unsorted linked list.
     */
    public void removeDup(){
        HashSet set = new HashSet<Integer>();
        Node previous = null;
        Node current = this;
        while (current != null){
            if(set.contains(current.data)){
                previous.next = current.next;
            }else{
                set.add(current.data);
                previous = current;
            }
            current = current.next;
        }
    }

    /*
     * Return Kth to Last:
     * Implement an algorithm to find the kth to last element of a singly linked list.
     * Iteration Solution
     * the last one, k = 1
     * the second last, k = 2
     */
    public Node lastKth(int k){
        int size = size();
        Node current = this;
        for (int i = 0; i < size - k; i++){
            current = current.next;
        }
        return current;
    }

    /*
     * Return Kth to Last:
     * Implement an algorithm to find the kth to last element of a singly linked list.
     * Recursive Solution
     * the last one, k = 1
     * the second last, k = 2
     */
    public Node lastKth2(int k){
        Pair<Integer, Node> result = recursiveThrough(k);
        return result.getValue1();
    }

    private Pair<Integer, Node> recursiveThrough(int k){
        if (this.next == null){
            return new Pair<>(1, this);
        }else{
            Pair<Integer, Node> result = this.next.recursiveThrough(k);
            if (result.getValue0().equals(k)){
                return result;
            }else{
                return new Pair<>(result.getValue0()+1, this);
            }

        }
    }
}
