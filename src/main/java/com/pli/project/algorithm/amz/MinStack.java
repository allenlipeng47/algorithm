package com.pli.project.algorithm.amz;

import java.util.Stack;

/**
 * Created by lipeng on 2016/8/10.
 */
public class MinStack {

    Stack<Integer> s;
    Stack<Integer> minBucket;

    public MinStack() {
        s = new Stack<>();
        minBucket = new Stack<>();
        minBucket.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        s.push(x);
        minBucket.push(Math.min(minBucket.peek(), x));
    }

    public void pop() {
        s.pop();
        minBucket.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return minBucket.peek();
    }

}
