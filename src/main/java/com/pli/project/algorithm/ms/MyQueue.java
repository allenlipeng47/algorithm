package com.pli.project.algorithm.ms;

import java.util.Stack;

/**
 * Created by lipeng on 2016/3/17.
 */
class MyQueue {

    Stack<Integer> head;
    Stack<Integer> tail;

    public MyQueue() {
        head = new Stack<Integer>();
        tail = new Stack<Integer>();
    }

    // Push element x to the back of queue.
    public void push(int x) {
        tail.add(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (head.isEmpty()) {
            while (!tail.isEmpty()) {
                head.add(tail.pop());
            }
        }
        head.pop();
    }

    // Get the front element.
    public int peek() {
        if (head.isEmpty()) {
            while (!tail.isEmpty()) {
                head.add(tail.pop());
            }
        }
        return head.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return head.isEmpty() && tail.isEmpty();
    }
}