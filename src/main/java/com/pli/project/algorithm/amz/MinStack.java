package com.pli.project.algorithm.amz;

import java.util.Stack;

/**
 * Created by lipeng on 2016/8/11.
 * https://leetcode.com/problems/min-stack/
 */
public class MinStack {

    Stack<Integer> stack;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = 0;
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0);
            min = x;
            return;
        }
        stack.push(x - min);
        min = Math.min(x, min);
    }

    public void pop() {
        int pop = stack.pop();
        if (pop < 0) {
            min = min - pop;
        }
    }

    public int top() {
        int pop = stack.peek();
        if (pop < 0) {
            return min;
        }
        return pop + min;
    }

    public int getMin() {
        return min;
    }

}
