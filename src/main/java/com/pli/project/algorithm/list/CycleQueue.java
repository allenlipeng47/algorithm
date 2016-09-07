package com.pli.project.algorithm.list;

/**
 * Created by lipeng on 2016/9/7.
 */
public class CycleQueue {
    private int[] queue;
    private final int len;
    private int rear;
    private int front;
    CycleQueue(int len) {
        this.len = len + 1;
        queue = new int[this.len];
        rear = front = 0;
    }
    int deQueue() {
        if (front == rear) {
            throw new RuntimeException("queue is empyt now.");
        }
        int result = queue[front];
        front = (front + 1) % len;
        return result;
    }
    void enQueue(int value) {
        if ((rear + 1) % len == front) {
            throw new RuntimeException("queue is full now.");
        }
        queue[rear] = value;
        rear = (rear + 1) % len;
    }
    void print() {
        for (int i = front; i != rear; i = (i + 1) % len) {
            System.out.print(queue[i] + "\t");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        CycleQueue queue = new CycleQueue(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println(queue.deQueue());
        queue.enQueue(4);
        System.out.println(queue.deQueue());
        queue.enQueue(5);
        queue.print();
        System.out.println();
    }
}