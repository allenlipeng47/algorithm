package com.pli.project.algorithm.leetcode;

import java.util.*;

/**
 * Created by lipeng on 2016/6/13.
 */
public class Twitter {

    int sequence = 0;

    class Tweet {
        int seqId;
        int id;
        public Tweet(int id) {
            this.id = id;
            this.seqId = sequence++;
        }
    }

    HashMap<Integer, ArrayList<Tweet>> tweets;
    HashMap<Integer, HashSet<Integer>> followList;

    /** Initialize your data structure here. */
    public Twitter() {
        tweets = new HashMap<>();
        followList = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        ArrayList<Tweet> list = tweets.getOrDefault(userId, new ArrayList<>());
        list.add(new Tweet(tweetId));
        tweets.put(userId, list);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        HashSet<Integer> follow = new HashSet<>(followList.getOrDefault(userId, new HashSet<>()));
        follow.add(userId); // self tweet is a part for retrieval.
        Queue<Tweet> queue = new PriorityQueue<>((t1, t2) -> t1.seqId - t2.seqId);
        for (int currUsr : follow) {
            List<Tweet> currTweetList = tweets.getOrDefault(currUsr, new ArrayList<>());
            // get tweet from newest and total is less than 10
            for (int i = currTweetList.size() - 1, j = 0; i >= 0 && j < 10; i--, j++) {
                queue.add(currTweetList.get(i));
                if (queue.size() > 10) {
                    queue.poll();
                }
            }
        }
        LinkedList<Integer> ans = new LinkedList<>();
        while (!queue.isEmpty()) {
            ans.addFirst(queue.poll().id);
        }
        return ans;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!followList.containsKey(followerId)) {
            followList.put(followerId, new HashSet<>());
        }
        followList.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        followList.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> p = new PriorityQueue<>((p1, p2) -> p1 - p2);
        p.add(1);
        p.add(3);
        p.add(5);
        p.add(2);
        p.add(4);
        p.add(6);
        p.forEach(i -> System.out.print(p.poll()));
    }

}
