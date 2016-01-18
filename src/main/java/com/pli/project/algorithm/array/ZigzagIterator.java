package com.pli.project.algorithm.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lipeng on 2016/1/17.
 */
public class ZigzagIterator {

    Iterator<Integer> v1, v2, currItr;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = this.currItr = v1.iterator();
        this.v2 = v2.iterator();
    }

    public int next() {
        int ans = 0;
        if (currItr.hasNext())
            ans = currItr.next();
        Iterator<Integer> anotherList = (currItr == v1) ? v2 : v1;
        if (anotherList.hasNext())
            currItr = anotherList;
        return ans;
    }

    public boolean hasNext() {
        return currItr.hasNext();
    }

    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        l1.add(1); l1.add(2);
        ArrayList<Integer> l2 = new ArrayList<Integer>();
        l2.add(3); l2.add(4); l2.add(5); l2.add(6);
        ZigzagIterator itr = new ZigzagIterator(l1, l2);
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