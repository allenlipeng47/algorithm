package com.pli.project.algorithm.ms;

import java.util.HashMap;

/**
 * Created by lipeng on 2016/3/19.
 */
public class LRUCache {

    Node head, tail;
    HashMap<Integer, Node> hm;
    int capacity;

    class Node {
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // take out node in double linked list.
    private Node takeOut(Node node) {
        if (node.pre != null) {
            node.pre.next = node.next;
        }
        if (node.next != null) {
            node.next.pre = node.pre;
        }
        if (head == node) {
            head = node.next;
        }
        if (tail == node) {
            tail = node.pre;
        }
        node.next = node.pre = null;
        return node;
    }

    private void setHead(Node node) {
        if (head == null) {
            head = tail = node;
        }
        else {
            node = takeOut(node);
            node.next = head;
            if (head == null) {
                head = tail = node;
            }
            else {
                head.pre = node;
            }
            head = node;
        }
    }

    private Node removeTail() {
        Node node = tail;
        if (node.pre != null) {
            node.pre.next = null;
        }
        tail = node.pre;
        node.pre = null;
        return node;

    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hm = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        Node node = hm.get(key);
        if (node != null) {
            setHead(node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        Node node = hm.get(key);
        if (node != null) {
            node.value = value;
            setHead(node);
            return;
        }
        node = new Node(key, value);
        setHead(node);
        hm.put(key, node);
        if (hm.size() > capacity) {
            Node last = removeTail();
            hm.remove(last.key);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.set(2, 1);
        System.out.println(lruCache.get(2));
    }

    public static void test1() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(2, 1);
        lruCache.set(1, 1);
        System.out.println(lruCache.get(2));
        lruCache.set(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }

}