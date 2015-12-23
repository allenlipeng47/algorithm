package com.pli.project.algorithm.recursion.NextElement;

import org.apache.commons.lang.ArrayUtils;

import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by pli on 12/22/2015.
 */
public class DataIterator<T> implements Iterator<Data<T>>{

    Data<T> data;

    public DataIterator(Data data) {
        this.data = data;
        stack.add(data);
    }

    private Stack<Data<T>> stack = new Stack<Data<T>>();

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public Data<T> next() {
        Data<T> curr = stack.pop();
        while (curr!=null && curr.isCollection()) {
            Stack<Data<T>> tempStack = new Stack<Data<T>>();
            Iterator<Data<T>> itr = curr.getCollection().iterator();
            while (itr.hasNext()) {
                tempStack.push(itr.next());
            }
            while (!tempStack.isEmpty())
                stack.push(tempStack.pop());
            curr = stack.pop();
        }
        return curr;
    }

    @Override
    public void remove() {

    }
}
