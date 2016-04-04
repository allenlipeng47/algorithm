package com.pli.project.algorithm.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lipeng on 2016/3/9.
 */
public class MyStackByQueue {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStackByQueue () {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push element x onto stack.
    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        Queue tmp = q1;
        q1 = q2;
        q2 = tmp;
    }

    // Removes the element on top of the stack.
    public void pop() {
        q1.poll();
    }

    // Get the top element.
    public int top() {
        if (!q1.isEmpty()) {
            return q1.peek();
        }
        return -1;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        Queue<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        System.out.println(list.poll());
        System.out.println(list.poll());
    }

}
