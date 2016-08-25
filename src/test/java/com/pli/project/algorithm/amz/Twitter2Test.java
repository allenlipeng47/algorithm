package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.*;

/**
 * Created by lipeng on 2016/8/15.
 */
public class Twitter2Test {


    @Test
    public void test1() {
        Twitter2 t = new Twitter2();
        t.postTweet(1, 5);
        List<Integer> l = t.getNewsFeed(1);
        assert l.get(0) == 5;
        t.follow(1, 2);
        t.postTweet(2, 6);
        l = t.getNewsFeed(1);
        assert l.get(0) == 6;
        assert l.get(1) == 5;
        t.unfollow(1, 2);
        l = t.getNewsFeed(1);
        assert l.get(0) == 5;
    }

    @Test
    public void test2() {
        Twitter2 t = new Twitter2();
        System.out.println(t.getNewsFeed(1));
    }

}
