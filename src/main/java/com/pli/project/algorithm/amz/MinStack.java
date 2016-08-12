package com.pli.project.algorithm.amz;

import java.util.Stack;

/**
 * Created by lipeng on 2016/8/11.
 * https://leetcode.com/problems/min-stack/
 */
public class MinStack {

    long min;
    Stack<Long> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.size() == 0) {
            min = x;
            stack.push(0l);
        }
        else {
            stack.push(x - min);
            min = Math.min(min, x);
        }
    }

    public void pop() {
        long pop = stack.pop();
        if (pop < 0) {
            min = min - pop;
        }
    }

    public int top() {
        long top = stack.peek();
        if (top < 0) {
            return (int)min;
        }
        return (int)(top + min);
    }

    public int getMin() {
        return (int)min;
    }

}
