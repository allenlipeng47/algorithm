package com.pli.project.algorithm.os;

import java.util.HashMap;

/**
 * Created by lipeng on 2015/9/29.
 */
public class LRUCache<K, V> {

    class Node{
        K key;
        V value;
        Node pre;
        Node next;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }

        public String toString(){
            if(this.next != null){
                return "(" + key + ", " + value + ") " + this.next;
            }
            return "(" + key + ", " + value + ") ";
        }
    }

    HashMap<K, Node> hm;
    int capacity;
    Node head;
    Node end;
    int num;

    public LRUCache(int capacity){
        hm = new HashMap<K, Node>();
        this.capacity = capacity;
        num = 0;
    }

    public LRUCache(){
        this(10);
    }

    public boolean put(K key, V value){
        Node node = hm.get(key);
        if(node != null){
            hm.get(key).value = value;
            return true;
        }
        node = new Node(key, value);
        hm.put(key, node);
        setHead(node);
        if(++num > capacity){
            remove(end.key);
        }
        return true;
    }

    public V remove(K key){
        Node node = hm.remove(key);
        if(node != null){
            pickupNode(node);
        }
        num--;
        return node.value;
    }

    public V get(K key){
        Node node = hm.get(key);
        pickupNode(node);
        setHead(node);
        return node.value;
    }

    private Node pickupNode(Node node){
        if(node==null){
            return null;
        }
        if(node.pre != null){
            node.pre.next = node.next;
        }
        if(node.next != null){
            node.next.pre = node.pre;
        }
        if(end == node){
            end = node.pre;
            end.next = null;
        }
        if(head == node){
            head = node.next;
            head.pre = null;
        }
        return node;
    }

    private void setHead(Node node){
        if(node == null){
            return;
        }
        if(head == null){
            head = end = node;
            return;
        }
        node.next = head;
        head.pre = node;
        head = node;
        head.pre = null;
        if(node.next == null){
            end = node;
        }
    }

    public String toString(){
        return head.toString();
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> lruCache = new LRUCache<String, Integer>(3);
        lruCache.put("a", 1);
        lruCache.put("b", 2);
        lruCache.put("c", 3);
        lruCache.put("d", 4);
        lruCache.get("b");
        lruCache.remove("c");
        lruCache.put("a", 1);
        lruCache.get("b");
        System.out.println();
    }

}