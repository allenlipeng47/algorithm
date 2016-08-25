package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.*;

/**
 * Created by lipeng on 2016/8/24.
 */
public class TwitterTest {

    @Test
    public void test1() {
        Twitter t = new Twitter();
        t.postTweet(1, 5);
        System.out.println(t.getNewsFeed(1));
        t.follow(1, 2);
        t.postTweet(2, 6);
        System.out.println(t.getNewsFeed(1));
        t.unfollow(1, 2);
        System.out.println(t.getNewsFeed(1));
    }
}
