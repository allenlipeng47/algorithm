package com.pli.project.algorithm.array;

import java.util.*;

/**
 * Created by lipeng on 2016/1/17.
 */
public class ZigzagIterator2 {

    LinkedList<Iterator<Integer>> queue;

    public ZigzagIterator2(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<Iterator<Integer>>();
        if (!v1.isEmpty())
            queue.addLast(v1.iterator());
        if (!v2.isEmpty())
            queue.addLast(v2.iterator());
    }

    public int next() {
        Iterator<Integer> itr = queue.removeFirst();
        Integer ans = itr.next();
        if (itr.hasNext())
            queue.addLast(itr);
        return ans;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        l1.add(1); l1.add(2);
        ArrayList<Integer> l2 = new ArrayList<Integer>();
        l2.add(3); l2.add(4); l2.add(5); l2.add(6);
        ZigzagIterator2 itr = new ZigzagIterator2(l1, l2);
        System.out.println(itr.next());
        System.out.println(itr.next());
        System.out.println(itr.next());
        System.out.println(itr.next());
        System.out.println(itr.hasNext());
        System.out.println(itr.next());
        System.out.println(itr.next());
        System.out.println(itr.hasNext());
    }
}