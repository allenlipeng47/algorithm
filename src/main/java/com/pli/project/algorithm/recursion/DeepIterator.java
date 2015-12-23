package com.pli.project.algorithm.recursion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by lipeng on 2015/12/22.
 * Write an Iterator that takes a nested(deep) list and flattens it out. For e.g. Collection A = {1, 2, {3, 4, 5, {6, 7}, {8,9}}, 10} When you call
 DeepIterator it = new DeepIterator(A) ;
 while(it.hasNext()){
    System.out.println(it.next);
 }
 */
public class DeepIterator {

    public Collection collection;

    Stack<Iterator> s;

    public DeepIterator(Collection collection) {
        this.collection = collection;
        s = new Stack<Iterator>();
        s.add(collection.iterator());
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }

    public Object next() {
        Object currElem = null;
        Iterator currItr;
        // while loop until found a currElem which is not Collection.
        while ((currItr=s.peek())!=null && (currElem=currItr.next()) instanceof Collection) {
            if(!currItr.hasNext())
                s.pop();    // each time, make sure the top element always has next
            s.push(((Collection)currElem).iterator());
        }
        if(!currItr.hasNext())
            s.pop();    // each time, make sure the top element always has next
        return currElem;
    }

    public static void main(String[] args) {
        /*a = {1, 2, {3, 4, 5, {6, 7}, {8,9}}, 10}
          b = {3, 4, 5, {6, 7}, {8,9}}
          c = {6, 7}
          d = {8,9}
        */
        ArrayList a = new ArrayList();
        ArrayList b = new ArrayList();
        ArrayList c = new ArrayList();
        ArrayList d = new ArrayList();
        a.add(1); a.add(2); a.add(b); a.add(10);
        b.add(3); b.add(4); b.add(5); b.add(c); b.add(d);
        c.add(6); c.add(7);
        d.add(8); d.add(9);
        DeepIterator itr = new DeepIterator(a);
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

}
