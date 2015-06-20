package com.pli.project.algorithm.hash.rollinghash;

import org.junit.Test;

/**
 * Created by lipeng on 2015/6/2.
 */
public class RollingHashQueueTest {
    @Test
    public void testCase1(){
        RollingHashQueue<Character> queue = new RollingHashQueue<Character>();
        queue.addLast('a');        //System.out.println(queue.getRollingHash());
        queue.addLast('b');        //System.out.println(queue.getRollingHash());
        queue.addLast('a');        //System.out.println(queue.getRollingHash());
        queue.addLast('d');        //System.out.println(queue.getRollingHash());
        int hashCode1 = queue.getRollingHash();
        queue.removeFirst();       // System.out.println(queue.getRollingHash());
        queue.addLast('a');        //System.out.println(queue.getRollingHash());
        queue.addLast('b');        //System.out.println(queue.getRollingHash());
        queue.removeFirst();        //System.out.println(queue.getRollingHash());
        queue.addLast('a');        //System.out.println(queue.getRollingHash());
        queue.removeFirst();        //System.out.println(queue.getRollingHash());
        queue.removeFirst();        //System.out.println(queue.getRollingHash());
        queue.addLast('d');         //System.out.println(queue.getRollingHash());
        int hashCode2 = queue.getRollingHash();
        assert(hashCode1==hashCode2);
    }

    @Test
    public void testCase2(){
        RollingHashQueue<Character> queue = new RollingHashQueue<Character>();
        queue.addLast('a');     System.out.println(queue.getRollingHash());
        queue.addLast('b');     System.out.println(queue.getRollingHash());
        queue.addLast('c');     System.out.println(queue.getRollingHash());
        int hash1 = queue.getRollingHash();
        queue.addLast('a');     System.out.println(queue.getRollingHash());
        queue.addLast('b');     System.out.println(queue.getRollingHash());
        queue.addLast('c');     System.out.println(queue.getRollingHash());
        queue.removeFirst();        System.out.println(queue.getRollingHash());
        queue.removeFirst();        System.out.println(queue.getRollingHash());
        queue.removeFirst();        System.out.println(queue.getRollingHash());
        int hash2 = queue.getRollingHash();
        assert hash1==hash2;
    }

    @Test
    public void testCase3(){
        RollingHashQueue<Character> queue = new RollingHashQueue<Character>();
        queue.addLast('a');     System.out.println(queue.getRollingHash());
        queue.addLast('b');     System.out.println(queue.getRollingHash());
        queue.addLast('c');     System.out.println(queue.getRollingHash());
        int hash1 = queue.getRollingHash();
        queue.addFirst('c');     System.out.println(queue.getRollingHash());
        queue.addFirst('b');     System.out.println(queue.getRollingHash());
        queue.addFirst('a');     System.out.println(queue.getRollingHash());
        queue.removeLast();        System.out.println(queue.getRollingHash());
        queue.removeLast();        System.out.println(queue.getRollingHash());
        queue.removeLast();        System.out.println(queue.getRollingHash());
        int hash2 = queue.getRollingHash();
        assert hash1==hash2;
    }
}
