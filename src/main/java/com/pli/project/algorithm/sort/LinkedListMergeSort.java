package com.pli.project.algorithm.sort;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lipeng on 2015/5/5.
 */
public class LinkedListMergeSort {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(5);
        Node n3 = new Node(9);
        Node n4 = new Node(8);
        Node n5 = new Node(7);
        Node n6 = new Node(6);
        Node n7 = new Node(2);
        Node n8 = new Node(3);
        Node n9 = new Node(5);
        Node n10 = new Node(1);
        n1.next = n2; n2.next = n3;
        n3.next = n4; n4.next = n5; n5.next = n6;
        n6.next = n7; n7.next = n8; n8.next = n9; n9.next = n10;
        n1 = linkedListMergeSort(n1);
        System.out.println(n1);
    }

    public static Node linkedListMergeSort(Node node){
        if(node == null || node.next == null){
            return node;
        }
        /** Divide node into 2  parts**/
        Node half1 = node, half2 = node, fast = node, half2Parent = node;
        while(fast != null && fast.next != null){
            half2Parent = half2;
            half2 = half2.next;
            fast = fast.next.next;
        }
        half2Parent.next = null;
        half1 = linkedListMergeSort(half1);
        half2 = linkedListMergeSort(half2);
        /** Merge half1 and half2 to node **/
        node = new Node(0); //need to define a fake head for Java
        Node tail = node;
        while( half1 != null && half2 != null){
            if(half1.value < half2.value){
                tail.next = half1;
                half1 = half1.next;
            }
            else{
                tail.next = half2;
                half2 = half2.next;
            }
            tail = tail.next;
        }
        if(half1 == null){
            tail.next = half2;
        }
        else{
            tail.next = half1;
        }
        return node.next;
    }

    static class Node {
        public int value;
        public Node next;
        Node(int value){
            this.value = value;
        }

        public String toString(){
            if(this.next == null){
                return String.valueOf(value);
            }
            return String.valueOf(this.value) + " " + this.next;
        }
    }
}
