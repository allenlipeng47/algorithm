package com.pli.project.algorithm.recursion.NextElement;

import java.util.Collection;

/**
 * Created by pli on 12/22/2015.
 */
public interface Data<T> {
    public boolean isCollection();

    public Collection<Data<T>> getCollection();

    public T getElement();
}
