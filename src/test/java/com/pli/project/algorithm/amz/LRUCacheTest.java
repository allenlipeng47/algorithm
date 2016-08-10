package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/9.
 */
public class LRUCacheTest {

    @Test
    public void test1() {
        LRUCache l = new LRUCache(3);
        l.set(1, 1);
        l.set(2, 2);
        l.set(3, 3);
        assert l.get(1) == 1;
        assert l.get(2) == 2;
        l.set(4, 4);
        assert l.get(3) == -1;
    }

    @Test
    public void test2() {
        LRUCache l = new LRUCache(1);
        l.set(2, 1);
        assert l.get(2) == 1;
        l.set(3, 2);
        assert l.get(2) == -1;
        assert l.get(3) == 2;
    }

}
