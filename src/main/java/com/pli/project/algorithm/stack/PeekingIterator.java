package com.pli.project.algorithm.stack;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by lipeng on 2016/1/17.
 * https://leetcode.com/problems/peeking-iterator/
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

 Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

 Call next() gets you 1, the first element in the list.

 Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

 You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.
 */
class PeekingIterator implements Iterator<Integer> {

    Integer peek;

    Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        peek = this.iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    public Integer next() {
        Integer ans = peek;
        if (iterator.hasNext())
            peek = iterator.next();
        else
            peek = null;
        return ans;
    }

    public boolean hasNext() {
        return (peek != null);
    }

    public void remove() {}

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        PeekingIterator itr = new PeekingIterator(list.iterator());
        System.out.println(itr.peek());
        System.out.println(itr.hasNext());
        System.out.println(itr.next());
        System.out.println(itr.peek());
        System.out.println(itr.next());
        System.out.println(itr.next());
        System.out.println(itr.peek());
    }
}
