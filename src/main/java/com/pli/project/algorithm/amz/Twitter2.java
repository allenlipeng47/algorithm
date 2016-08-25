package com.pli.project.algorithm.amz;

import java.util.*;

/**
 * Created by lipeng on 2016/8/15.
 * https://leetcode.com/problems/design-twitter/
 * Each user has a tweet list. The tweet is a linkedlist.
 * User should follow user itself.
 * When get a user's feed, 1st should get all the tweet of each followed user. Then use priority queue to pop it.
 */
public class Twitter2 {

    public static int timestamp = 0;

    class Tweet {
        int tweetId;
        int timestamp;
        Tweet next;
        public Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }

    class User {
        int userId;
        Set<Integer> followList;
        Tweet tweetHead;

        public User(int userId) {
            this.userId = userId;
            followList = new HashSet<>();
            follow(userId);
        }

        public void follow(int followId) {
            followList.add(followId);
        }

        public void unfollow(int followId) {
            followList.remove(followId);
        }

        public void postTweet(int tweetId) {
            Tweet tweet = new Tweet(tweetId, timestamp++);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }

    }

    Map<Integer, User> users;

    /** Initialize your data structure here. */
    public Twitter2() {
        users = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }
        users.get(userId).postTweet(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Queue<Tweet> queue = new PriorityQueue<>((t1, t2) -> t2.timestamp - t1.timestamp);
        if (!users.containsKey(userId)) {
            return new ArrayList<>();
        }
        List<Integer> feed = new ArrayList<>();
        for (Integer followee : users.get(userId).followList) {
            Tweet tweet = users.get(followee).tweetHead;
            if (tweet != null) {
                queue.add(tweet);
            }
        }
        for (int i = 0; i < 10 && !queue.isEmpty(); i++) {
            Tweet tweet = queue.poll();
            feed.add(tweet.tweetId);
            if (tweet.next != null) {
                queue.add(tweet.next);
            }
        }
        return feed;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            users.put(followerId, new User(followerId));
        }
        if (!users.containsKey(followeeId)) {
            users.put(followeeId, new User(followeeId));
        }
        users.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!users.containsKey(followerId) || followeeId == followerId) {
            return;
        }
        users.get(followerId).unfollow(followeeId);
    }

}
