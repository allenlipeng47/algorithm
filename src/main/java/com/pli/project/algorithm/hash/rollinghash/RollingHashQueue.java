package com.pli.project.algorithm.hash.rollinghash;

import java.math.BigInteger;
import java.util.LinkedList;

/**
 * Created by lipeng on 2015/5/16.
 */
public class RollingHashQueue<E> {

    // base is the number of characters in input alphabet
    private final int base = 31;

    // q is a prime number used for evaluating Rabin Karp's Rolling hash
    private final int q = 103;

    //magic base^(n-1). n is the number of element the list has.
    private int magic = 1;

    LinkedList<E> list;

    private int hash;

    RollingHashQueue(){
        list = new LinkedList<E>();
    }

    public boolean enQueue(E e){
        list.addLast(e);
        hash = ((hash * base) % q + e.hashCode()) % q;
        magic = (magic * base) % q;
        return true;
    }

    public E deQueue(){
        if(list==null || list.size()==0){
            return null;
        }
        int magicModInverse = BigInteger.valueOf(base).modInverse(BigInteger.valueOf(q)).intValue();
        magic = (magic * magicModInverse) % q;
        hash = (hash - (magic * list.get(0).hashCode()) % q + q) % q;
        E e = list.remove(0);
        return e;
    }

    public int hashCode() {
        return this.hashCode();
    }

    public static void main(String[] args) {
        RollingHashQueue<Character> queue = new RollingHashQueue<Character>();
        queue.enQueue('a');        System.out.println(queue.hash);
        queue.enQueue('b');        System.out.println(queue.hash);
        queue.enQueue('a');        System.out.println(queue.hash);
        queue.enQueue('d');        System.out.println(queue.hash);
        queue.deQueue();        System.out.println(queue.hash);
        queue.enQueue('a');        System.out.println(queue.hash);
        queue.enQueue('b');        System.out.println(queue.hash);
        queue.deQueue();        System.out.println(queue.hash);
        queue.enQueue('a');        System.out.println(queue.hash);
        queue.deQueue();        System.out.println(queue.hash);
        queue.deQueue();        System.out.println(queue.hash);
        LinkedList<Character> list = new LinkedList<Character>();
        list.add('a');        System.out.println(list.hashCode());
        list.add('b');        System.out.println(list.hashCode());
        list.add('a');        System.out.println(list.hashCode());
        list.remove(0);        System.out.println(list.hashCode());
        list.add('d');        System.out.println(list.hashCode());
        list.remove(0);        System.out.println(list.hashCode());
        list.add('a');        System.out.println(list.hashCode());
        list.remove(0);        System.out.println(list.hashCode());
        list.add('b');        System.out.println(list.hashCode());
        list.add('a');        System.out.println(list.hashCode());
        list.remove(0);        System.out.println(list.hashCode());
        System.out.println();
    }

}
