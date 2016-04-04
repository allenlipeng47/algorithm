package com.pli.project.algorithm.recursion.NextElement;

import com.pli.project.algorithm.exercise2014.StringComparisonOrder;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by pli on 12/22/2015.
 */
public class Node<T> implements Data<T> {

    T element;

    Collection<Data<T>> list;

    public boolean isCollection() {
        return list!=null;
    }

    public Collection<Data<T>> getCollection() {
        return list;
    }

    public T getElement() {
        return element;
    }

    public Node(T element) {
        this.element = element;
    }

    public void setList(Collection<Data<T>> list) {
        this.list = list;
    }

    public String toString() {
        return String.valueOf(element);
    }

    public DataIterator<T> getIterator() {
        return new DataIterator<T>(this);
    }

}
