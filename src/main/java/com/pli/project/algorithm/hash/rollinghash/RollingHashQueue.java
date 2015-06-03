package com.pli.project.algorithm.hash.rollinghash;

import lombok.Getter;
import org.junit.Test;

import java.math.BigInteger;
import java.util.LinkedList;

/**
 * Created by lipeng on 2015/5/16.
 */
public class RollingHashQueue<E> {

    /** base is the number of characters in input alphabet **/
    private final int base = 31;

    /** q is a prime number used for evaluating Rabin Karp's Rolling hash **/
    private final int q = 103;

    /** magic base^(n-1). n is the number of element the list has. **/
    private int magic = 1;

    LinkedList<E> list;

    @Getter
    private int hash;

    private int magicModInverse;

    RollingHashQueue(){
        list = new LinkedList<E>();
        magicModInverse = BigInteger.valueOf(base).modInverse(BigInteger.valueOf(q)).intValue();
    }

    /** enQueue, add element to queue tail **/
    public boolean addLast(E e){
        list.addLast(e);
        hash = ((hash * base) % q + e.hashCode()) % q;
        magic = (magic * base) % q;
        return true;
    }

    /** add element to queue head **/
    public boolean addFirst(E e){
        list.addFirst(e);
        hash = ((magic * e.hashCode()) % q + hash ) % q;
        magic = (magic * base) % q;
        return true;
    }

    /** deQueue, remove element from queue head **/
    public E removeFirst(){
        if(list==null || list.size()==0){
            return null;
        }
        magic = (magic * magicModInverse) % q;
        hash = (hash - (magic * list.get(0).hashCode()) % q + q) % q;
        E e = list.remove(0);
        return e;
    }

    /** remove element from queue tail **/
    public E removeLast(){
        if(list==null || list.size()==0){
            return null;
        }
        magic = (magic * magicModInverse) % q;
        hash = (((hash - list.getLast().hashCode() + q) % q) * magicModInverse) % q;
        E e = list.removeLast();
        return e;
    }

    public int hashCode() {
        return this.hashCode();
    }

    public static void main(String[] args) {
        System.out.println("a");
    }

}
