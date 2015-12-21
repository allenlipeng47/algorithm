package com.pli.project.algorithm.list;

/**
 * Created by pli on 12/21/2015.
 * Given a linkedlist, and a number n. Split the list to 2 parts: elements in left parts are less than n, elements in right parts are greater than n
 * Despite change of splitting, the order between elements doesn't change.
 * For example 1, 5, 3, 3, 2, 7, 8, n=3, should return 1, 3, 3, 2, 5, 7, 8
 */
public class SplitLinkedList {

    public static Node splitLinkedList(Node node, int n) {
        assert node!=null;
        Node leftHead=null, leftTail=null, rightHead=null, rightTail=null;
        while (node!=null) {
            if(node.value<=n) {
                if(leftTail==null) {
                    leftHead = leftTail = node;
                }
                else {
                    leftTail.next = node;
                    leftTail = node;
                }
            }
            else {
                if(rightTail==null) {
                    rightHead = rightTail = node;
                }
                else {
                    rightTail.next = node;
                    rightTail = node;
                }
            }
            node = node.next;
        }
        leftTail.next = rightHead;
        node = leftHead;
        leftHead=leftTail=rightHead=rightTail=null; // release unused reference.
        return node;
    }

    public static class Node {
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }

        public String toString() {
            if(next==null)
                return String.valueOf(value);
            else
                return value + " " + next;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(5);
        Node n2 = new Node(1);
        Node n3 = new Node(3);
        Node n4 = new Node(3);
        Node n5 = new Node(2);
        Node n6 = new Node(7);
        Node n7 = new Node(8);
        n1.next = n2; n2.next=n3; n3.next=n4; n4.next=n5; n5.next=n6; n6.next=n7;
        n1 = splitLinkedList(n1, 3);
        System.out.println(n1);
    }
}
