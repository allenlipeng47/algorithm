package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.*;

/**
 * Created by lipeng on 2016/8/15.
 */
public class TwitterTest {


    @Test
    public void test1() {
        Twitter t = new Twitter();
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
        Twitter t = new Twitter();
        System.out.println(t.getNewsFeed(1));
    }

}
