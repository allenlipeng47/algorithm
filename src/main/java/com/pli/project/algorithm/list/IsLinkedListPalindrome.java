package com.pli.project.algorithm.list;

/**
 * Created by pli on 12/21/2015.
 * If a node is palindrome. O(n) time, O(1) space solution.
 * Solution is to find the middle node. For right half, reverse it. Then compare left and reversed right.
 * In the end, reverse right half back.
 */
public class IsLinkedListPalindrome {

    static class Node {
        int value;
        Node next;
        public Node (int value) {
            this.value = value;
        }
        public String toString() {
            if (next != null) {
                return value + ", " + next;
            }
            else {
                return String.valueOf(value);
            }
        }
    }

    public static Node reverse(Node node) {
        Node pre = null, curr = node;
        while (curr != null) {
            Node tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }

    public static boolean isNodePalindrome(Node node) {
        if (node == null) {
            return true;
        }
        Node slow = node, fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) {
            fast = reverse(slow.next.next);
        }
        else {
            fast = reverse(slow.next);
        }
        Node left = node, right = fast;
        while (right != null) {
            if (left.value != right.value) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        fast = reverse(fast);
        return true;
    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(2);
        Node n5 = new Node(1);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
        System.out.println(isNodePalindrome(n1));
    }
}



