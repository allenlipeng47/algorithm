package com.pli.project.algorithm.ms;

/**
 * Created by lipeng on 2016/3/18.
 */
public class CircleQueue {

    int size;
    int head, tail;
    int[] arr;

    public CircleQueue(int size) {
        this.size = size + 1;
        arr = new int[this.size];
        head = tail = 0;
    }

    public void enQueue(int ele) {
        if ((tail + 1) % size == head) {
            return;
        }
        arr[tail] = ele;
        tail = (tail + 1) % size;
    }

    public int deQueue() {
        if (head == tail) {
            return Integer.MIN_VALUE;
        }
        int ans = arr[head];
        head = (head + 1) % size;
        return ans;
    }

    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(4);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        queue.enQueue(6);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println();
    }
}
