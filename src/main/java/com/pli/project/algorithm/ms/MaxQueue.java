package com.pli.project.algorithm.ms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lipeng on 2016/3/18.
 */
public class MaxQueue {

    LinkedList<Integer> queue;
    LinkedList<Integer> maxList;

    public MaxQueue() {
        queue = new LinkedList<>();
        maxList = new LinkedList<>();
    }

    public void enQueue(int ele) {
        while (!maxList.isEmpty() && ele > maxList.getLast()) {
            maxList.removeLast();
        }
        maxList.addLast(ele);
        queue.addLast(ele);
    }

    public int deQueue() {
        if (queue.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        int ans = queue.removeFirst();
        if (ans == maxList.getFirst()) {
            maxList.removeFirst();
        }
        return ans;
    }

    public int getMax() {
        return maxList.getFirst();
    }

    public static void printMaxInWindow(int[] arr) {
        MaxQueue queue = new MaxQueue();
        int i = 0;
        for (; i < 3; i++) {
            queue.enQueue(arr[i]);
        }
        System.out.println(queue.getMax());
        for (; i < arr.length; i++) {
            queue.enQueue(arr[i]);
            queue.deQueue();
            System.out.println(queue.getMax());
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 2, 3, 4, 5, 6};
        printMaxInWindow(arr);
    }
}
