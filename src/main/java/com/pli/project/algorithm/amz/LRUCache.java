package com.pli.project.algorithm.amz;

import java.util.HashMap;

/**
 * Created by lipeng on 2016/8/9.
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {

    class Node {
        int key;
        int val;
        Node pre;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    HashMap<Integer, Node> hm;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.hm = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = hm.get(key);
        if (node == null) {
            return -1;
        }
        pickNode(node);
        setHead(node);
        return node.val;
    }

    public void set(int key, int value) {
        Node node = hm.get(key);
        if (node != null) {
            pickNode(node);
            setHead(node);
            node.val = value;
            return;
        }
        node = new Node(key, value);
        setHead(node);
        hm.put(key, node);
        if (hm.size() > capacity) {
            hm.remove(tail.pre.key);
            tail.pre.pre.next = tail;
            tail.pre = tail.pre.pre;
            return;
        }
    }

    public void pickNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void setHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

}
