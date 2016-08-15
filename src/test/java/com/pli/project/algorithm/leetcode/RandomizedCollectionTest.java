package com.pli.project.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by lipeng on 2016/8/14.
 */
public class RandomizedCollectionTest {

    @Test
    public void test1() {
        RandomizedCollection r = new RandomizedCollection();
        r.insert(1);
        r.insert(2);
        r.insert(2);
        r.insert(2);
        r.insert(1);
        r.insert(3);
        r.insert(3);
        r.remove(2);
        assert r.list.get(0) == 1;
        assert r.list.get(1) == 3;
        assert r.list.get(2) == 2;
        assert r.list.get(3) == 2;
        assert r.list.get(4) == 1;
        assert r.list.get(5) == 3;
    }

}
