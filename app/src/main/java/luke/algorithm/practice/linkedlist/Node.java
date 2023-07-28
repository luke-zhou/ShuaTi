package luke.algorithm.practice.linkedlist;

import java.util.HashSet;

public class Node {
    Node next = null;
    int data;

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
        int size = this.size();
        int[] a = new int[size];
        int i = 0;
        Node current = this;
        while (current != null){
            a[i++] = current.data;
            current = current.next;
        }

        return a;
    }

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
}
