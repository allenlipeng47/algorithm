package com.pli.project.algorithm.list;

/**
 * Created by lipeng on 2016/4/30.
 */
public class IsLinkedListPalindrome2 {

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

    private static Node reverse(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node pre = node, curr = node.next;
        pre.next = null;
        while (curr != null) {
            Node tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }

    private static boolean isNodePalindrome(Node node) {
        if (node == null || node.next == null) {
            return true;
        }
        Node slow = node, fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node reverseList = reverse(slow.next);
        slow.next = null;
        Node n1 = node, n2 = reverseList;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(3);
        Node n5 = new Node(2);
        Node n6 = new Node(1);
        Node n7 = new Node(1);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6; // n6.next = n7;
        System.out.println(isNodePalindrome(n1));
    }

}
