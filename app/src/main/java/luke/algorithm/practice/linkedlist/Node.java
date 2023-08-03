package luke.algorithm.practice.linkedlist;

import org.javatuples.Pair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Stack;

public class Node {
    public Node next = null;
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

    public static Node create(int[] a) {
        Node preHead = new Node(0);
        Node current = preHead;
        for (int i : a) {
            Node n = new Node(i);
            current.next = n;
            current = n;
        }

        return preHead.next;
    }

    public int size() {
        int size = 1;
        Node current = this.next;
        while (current != null) {
            size++;
            current = current.next;
        }

        return size;
    }

    public int[] toArray() {
        int size = size();
        int[] a = new int[size];
        int i = 0;
        Node current = this;
        while (current != null) {
            a[i++] = current.data;
            current = current.next;
        }

        return a;
    }

    /*
     * Remove Dups:
     * Write code to remove duplicates from an unsorted linked list.
     */
    public void removeDup() {
        HashSet set = new HashSet<Integer>();
        Node previous = null;
        Node current = this;
        while (current != null) {
            if (set.contains(current.data)) {
                previous.next = current.next;
            } else {
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
    public Node lastKth(int k) {
        int size = size();
        Node current = this;
        for (int i = 0; i < size - k; i++) {
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
    public Node lastKth2(int k) {
        Pair<Integer, Node> result = recursiveThrough(k);
        return result.getValue1();
    }

    private Pair<Integer, Node> recursiveThrough(int k) {
        if (this.next == null) {
            return new Pair<>(1, this);
        } else {
            Pair<Integer, Node> result = this.next.recursiveThrough(k);
            if (result.getValue0().equals(k)) {
                return result;
            } else {
                return new Pair<>(result.getValue0() + 1, this);
            }

        }
    }

    /*
     * Delete Middle Node:
     * Implement an algorithm to delete a node in the middle (i.e., any node but
     * the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
     * that node.
     * EXAMPLE
     * Input:the node c from the linked list a->b->c->d->e->f
     * Result: nothing is returned, but the new linked list looks like a->b->d->e->f
     */
    public void remove(Node n) {
        n.data = n.next.data;
        n.next = n.next.next;
    }

    /*
     * Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
     * before all nodes greater than or equal to x. If x is contained within the list the values of x only need
     * to be after the elements less than x (see below). The partition element x can appear anywhere in the
     * "right partition"; it does not need to appear between the left and right partitions.
     * EXAMPLE
     * Input:3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
     * Output:3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
     */
    public Node partition(int p) {
        Node left = new Node(0);
        Node leftCurrent = left;
        Node right = new Node(p);
        Node rightCurrent = right;
        Node current = this;
        while (current != null) {
            if (current.data < p) {
                leftCurrent.next = current;
                leftCurrent = current;
                rightCurrent.next = null;
            } else {
                rightCurrent.next = current;
                rightCurrent = current;
                leftCurrent.next = null;
            }

            current = current.next;
        }
//        System.out.println(Arrays.toString(left.toArray()));
//        System.out.println(Arrays.toString(right.toArray()));

        leftCurrent.next = right.next;
        return left.next;
    }

    /*
     * Sum Lists:
     * You have two numbers represented by a linked list, where each node contains a single
     * digit. The digits are stored in reverse order,such that the 1's digit is at the head of the list. Write a
     * function that adds the two numbers and returns the sum as a linked list.
     * EXAMPLE
     * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
     * Output: 2 -> 1 -> 9. That is,912.
     */
    public static Node sumReverse(Node n1, Node n2) {
        Node n1c = n1;
        Node n2c = n2;
        Node left = null;
        int addition = 0;
        Node preResult = new Node(0);
        Node current = preResult;
        while (true) {
            if (n1c == null) {
                left = n2c;
                break;
            }
            if (n2c == null) {
                left = n1c;
                break;
            }
            int result = n1c.data + n2c.data + addition;
            addition = result / 10;
            current.next = new Node(result % 10);
            n1c = n1c.next;
            n2c = n2c.next;
            current = current.next;
        }

        if (left != null) {
            left.data += addition;
            current.next = left;
        }

        return preResult.next;
    }

    /*
     * Sum Lists:
     * You have two numbers represented by a linked list, where each node contains a single
     * digit. The digits are stored in forward order,such that the 1's digit is at the head of the list. Write a
     * function that adds the two numbers and returns the sum as a linked list.
     * EXAMPLE
     * Input: (6-> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
     * Output: 9 -> 1 -> 2. That is,912.
     */
    public static Node sumForward(Node n1, Node n2) {
        int len1 = n1.size();
        int len2 = n2.size();
        Node preResult = new Node(0);
        Node current = preResult;
        Node longList = (len1 > len2) ? n1 : n2;
        Node shortList = (len1 > len2) ? n2 : n1;
        int longLen = Math.max(len1, len2);
        int shortLen = Math.min(len1, len2);
        while (longLen != shortLen) {
            current.next = longList;
            current = longList;
            longList = longList.next;
            longLen--;
        }
        while (longLen > 0) {
            int result = longList.data + shortList.data;
            int addition = result / 10;
            current.data += addition;
            current.next = new Node(result % 10);
            longList = longList.next;
            shortList = shortList.next;
            current = current.next;
            longLen--;
        }

        return preResult.next;
    }

    /*
     * Palindrome:
     * Implement a function to check if a linked list is a palindrome
     */
    public boolean isPalindrome() {
        Node slow = this;
        Node fast = this;
        Stack<Integer> s = new Stack<>();
        while (fast != null && fast.next != null) {
            s.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.data != s.pop()) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }

    public Node last() {
        return lastKth(1);
    }

    /*
     * Intersection:
     * Given two (singly) linked lists, determine if the two lists intersect. Return the
     * intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
     * kth node of the first linked list is the exact same node (by reference) as the jth node of the second
     * linked list, then they are intersecting.
     */
    public static boolean hasIntersection(Node a, Node b) {
        int lengthA = a.size();
        int lengthB = b.size();
        int length = Math.min(lengthA, lengthB);
        a = a.lastKth(length);
        b = b.lastKth(length);
        for (int i = 0; i < length; i++) {
            if (a == b) {
                return true;
            }
            a = a.next;
            b = b.next;
        }
        return false;
    }

    /*
     * Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
     * beginning of the loop.
     * DEFINITION
     * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
     * as to make a loop in the linked list.
     * EXAMPLE
     * Input:A - > B - > C - > D - > E - > C [the same C as earlier]
     * Output:C
     */

    public Node loopHead(){
        Node slow = this;
        Node fast = this;
        Node collisionSpot = null;
        while (fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                collisionSpot = fast;
                break;
            }
        }

        if (collisionSpot == null) return null;

        Node head = this;
        while(head != collisionSpot){
            head = head.next;
            collisionSpot = collisionSpot.next;
        }

        return head;
    }
}
