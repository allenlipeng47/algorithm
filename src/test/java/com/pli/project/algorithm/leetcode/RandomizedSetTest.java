package com.pli.project.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by lipeng on 2016/8/14.
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
public class RandomizedSetTest {

    @Test
    public void test1() {
        RandomizedSet r = new RandomizedSet();
        r.insert(0);
        r.insert(1);
        r.insert(2);
        r.insert(3);
        r.remove(3);
        assert r.list.get(0) == 0;
        assert r.list.get(1) == 1;
        assert r.list.get(2) == 2;
        r.remove(0);
        assert r.list.get(0) == 2;
        assert r.list.get(1) == 1;
    }

}
