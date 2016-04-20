package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by lipeng on 2016/4/18.
 * This version is good for when list is never empty. Doesn't fit for []
 */
public class NestedIteratorII implements Iterator<Integer> {

    Stack<Iterator<NestedInteger>> s;

    public NestedIteratorII(List<NestedInteger> nestedList) {
        s = new Stack<>();
        s.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        NestedInteger curr;
        while (!(curr = s.peek().next()).isInteger()) {
            if (!s.peek().hasNext()) {
                s.pop();
            }
            s.push(curr.getList().iterator());
        }
        if (!s.peek().hasNext()) {
            s.pop();
        }
        return curr.getInteger();
    }

    @Override
    public boolean hasNext() {
        return !s.isEmpty();
    }

    public static void main(String[] args) {
        List<NestedInteger> list = new ArrayList<>();
        NestedIteratorII itr = new NestedIteratorII(list);
        System.out.println(itr.next());
    }
}