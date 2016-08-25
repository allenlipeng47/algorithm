package com.pli.project.algorithm.amz;

import java.util.*;

/**
 * Created by lipeng on 2016/8/24.
 */
public class Twitter {

    static int timestamp = 0;

    static class Tweet {
        int tweetId;
        int timestamp;
        Tweet next;
        public Tweet(int tweetId) {
            this.tweetId = tweetId;
            this.timestamp = timestamp++;
        }
    }

    static class User {
        int userId;
        Tweet tweet;
        public Set<User> follow;

        public User(int userId) {
            this.userId = userId;
            follow = new HashSet<>();
            follow(this);
        }

        public void follow(User followee) {
            follow.add(followee);
        }

        public void unfloow(User followee) {
            follow.remove(followee);
        }

        public void post(Tweet tweet) {
            tweet.next = this.tweet;
            this.tweet = tweet;
        }

    }

    Map<Integer, User> map;

    /** Initialize your data structure here. */
    public Twitter() {
        map = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        map.putIfAbsent(userId, new User(userId));
        Tweet tweet = new Tweet(tweetId);
        map.get(userId).post(tweet);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        if (!map.containsKey(userId)) {
            return feed;
        }
        Queue<Tweet> queue = new PriorityQueue<>((p1, p2) -> p2.timestamp - p1.timestamp);
        map.get(userId).follow.stream().filter(user -> user.tweet != null).forEach(user -> queue.add(user.tweet));
        for (int i = 0; !queue.isEmpty() && i < 10; i++) {
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
        map.putIfAbsent(followeeId, new User(followeeId));
        map.putIfAbsent(followerId, new User(followerId));
        map.get(followerId).follow(map.get(followeeId));
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)) {
            return;
        }
        map.get(followerId).unfloow(map.get(followeeId));
    }

}
