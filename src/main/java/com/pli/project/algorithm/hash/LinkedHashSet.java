package com.pli.project.algorithm.hash;

import java.util.HashMap;

/**
 * Created by lipeng on 2016/1/3.
 */
public class LinkedHashSet<T extends Comparable <T>> {
    private Node<T> head, tail;
    private HashMap<T, Node> hm;

    public LinkedHashSet() {
        hm = new HashMap<T, Node>();
        head = tail = null;
    }

    public void add(T value) {
        if(!hm.containsKey(value)) {
            Node<T> node = new Node<T>(value);
            hm.put(value, node);
            if(head == null)
                head = tail = node;
            else {
                tail.next = node;
                node.pre = tail;
                tail = node;
            }
        }
    }

    public Node getNode(T value) {
        return hm.get(value);
    }

    public boolean isReplacable(T value) {
        Node node = hm.get(value);
        if(node == null || node.next == null || node.value.compareTo(node.next.value) <= 0)
            return false;
        else
            return true;
    }

    public void remove(T value) {
        Node node = hm.get(value);
        if(node !=null) {
            Node pre = node.pre;
            Node next = node.next;
            if(pre != null)
                pre.next = next;
            else
                head = next;
            if(next != null)
                next.pre = pre;
            else
                tail = pre;
        }
        hm.remove(value);
        node = null;
    }

    public boolean contains(T value) {
        if(hm.get(value) != null)
            return true;
        else
            return false;
    }

    public T getLast() {
        if(tail !=null)
            return tail.value;
        else
            return null;
    }

    public T getFirst() {
        if(head != null)
            return head.value;
        else
            return null;
    }

    public String toString() {
        return head.toString();
    }


    private class Node<T extends Comparable <T>> {
        T value;
        Node next;
        Node pre;

        public Node(T value) {
            this.value = value;
        }

        public String toString() {
            if(this.next == null)
                return String.valueOf(value);
            else
                return String.valueOf(value) + this.next;
        } // toString
    } // class Node
}