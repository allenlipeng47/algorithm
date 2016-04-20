package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by lipeng on 2016/4/18.
 */
public class NestedIterator implements Iterator<Integer> {

    Stack<Iterator<NestedInteger>> s;
    Integer currInteger = null;

    public NestedIterator(List<NestedInteger> nestedList) {
        s = new Stack<>();
        s.push(nestedList.iterator());
        refresh();
    }

    private void refresh() {
        currInteger = null;
        while (!s.isEmpty()) {
            if (!s.peek().hasNext()) {  // iterator is empty. Another situation could be that iterator for the list is empty at all
                s.pop();
                continue;
            }
            NestedInteger curr = s.peek().next();
            if (curr.isInteger()) {
                currInteger = curr.getInteger();
                return;
            }
            // comes to here, it means it is a list
            s.push(curr.getList().iterator());
        }
    }

    @Override
    public Integer next() {
        Integer tmp = currInteger;
        refresh();
        return tmp;
    }

    @Override
    public boolean hasNext() {
        return currInteger != null;
    }

    public static void main(String[] args) {
        List<NestedInteger> list = new ArrayList<>();
        NestedIterator itr = new NestedIterator(list);
        System.out.println(itr.next());
    }
}