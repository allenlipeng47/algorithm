package com.pli.project.algorithm.array;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by lipeng on 2015/11/7.
 */
public class MinConsecutiveSubStr {

    public static void main(String[] args) {
        Queue queue = new Queue("adobecodebanc", "abc");
        System.out.println(queue.getResult());
    }

    public static class Element {
        public Element pre;
        public Element next;
        public int pos = -1;
    }

    public static class Queue {
        Element[] queue = new Element[255];
        String s;

        int minPos = Integer.MAX_VALUE;
        int maxPos = Integer.MIN_VALUE;

        int windowSize = Integer.MAX_VALUE;
        int windowStart = -1;
        int windowEnd = -1;

        Element head;
        Element tail;

        public Queue(String s, String t) {
            this.s = s;
            Element pre = head = queue[t.charAt(0)-'a'] = new Element();
            for(int i=1; i<t.length(); i++) {
                Element curr = queue[t.charAt(i)-'a'] = new Element();
                pre.next = curr;
                curr.pre = pre;
                pre = curr;
            }
            tail = pre;
        }

        public void enQueue(int pos) {
            if(queue[s.charAt(pos)-'a']==null) {
                return;
            }
            Element curr = queue[s.charAt(pos)-'a'];
            curr.pos = pos;
            //move curr to tail
            if(curr!=head) {
                curr.pre.next = curr.next;
            }
            else {
                head = curr.next;
                curr.next.pre = null;
            }
            if(curr!=tail) {
                curr.next.pre = curr.pre;
                tail.next = curr;
                curr.pre = tail;
                tail = curr;
                tail.next = null;
            }
            updateWindow();
        }

        private void updateWindow() {
            if(head.pos!=-1 && tail.pos-head.pos<windowSize) {
                windowSize = tail.pos-head.pos;
                windowStart = head.pos;
                windowEnd = tail.pos;
            }
        }

        private void compute() {
            for(int i=0; i<s.length(); i++) {
                enQueue(i);
            }
        }

        public String getResult() {
            compute();
            if(windowSize==Integer.MAX_VALUE) {
                return "";
            }
            else {
                return s.substring(windowStart, windowEnd+1);
            }
        }

    }
}
