package com.pli.project.algorithm.leetcode;

import java.util.*;

/**
 * Created by lipeng on 2016/3/22.
 */
public class ContainDuplicateIII {

    private class MaxMinQueue {
        LinkedList<Integer> queue;
        LinkedList<Integer> minQueue;
        LinkedList<Integer> maxQueue;


        public MaxMinQueue() {
            queue = new LinkedList<>();
            minQueue = new LinkedList<>();
            maxQueue = new LinkedList<>();
        }

        public void enQueue(int ele) {
            while (!maxQueue.isEmpty() && ele >= maxQueue.peek()) {
                maxQueue.pop();
            }
            maxQueue.add(ele);
            while (!minQueue.isEmpty() && ele <= minQueue.peek()) {
                minQueue.pop();
            }
            minQueue.add(ele);
        }
    }

    // Wrote wrong one. This is to find the abs(max - min) should be greater than the value.
    public boolean containsNearbyAlmostDuplicateWrong(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 0 || k == 0) {
            return false;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> maxQueue = new LinkedList<>();
        LinkedList<Integer> minQueue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            queue.addLast(nums[i]);
            while (!maxQueue.isEmpty() && nums[i] > maxQueue.getLast()) {
                maxQueue.removeLast();
            }
            maxQueue.addLast(nums[i]);
            while (!minQueue.isEmpty() && nums[i] < minQueue.getLast()) {
                minQueue.removeLast();
            }
            minQueue.addLast(nums[i]);
            if (i > k) {
                int remove = queue.removeFirst();
                if (maxQueue.getFirst() == remove) {
                    maxQueue.removeFirst();
                }
                if (minQueue.getFirst() == remove) {
                    minQueue.removeFirst();
                }
            }
            if (i > 0 && Math.abs(maxQueue.getFirst() - minQueue.getFirst()) <= t) {
                return true;
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int idx, int value) {
        if (nums == null || nums.length <= 1 || idx < 1 || value < 0) {
            return false;
        }
        long size = (long)value + 1;
        HashMap<Long, Integer> bucket = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > idx) {   // remove first
                long lastBucket = ((long)nums[i - idx - 1] - Integer.MIN_VALUE) / size;
                bucket.remove(lastBucket);
            }
            long bucketPos = ((long)nums[i] - Integer.MIN_VALUE) / size;
            if (bucket.containsKey(bucketPos)) {
                return true;
            }
            bucket.put(bucketPos, nums[i]);
            if (bucket.containsKey(bucketPos - 1) && (long)nums[i] - bucket.get(bucketPos - 1) <= value ||
                    bucket.containsKey(bucketPos + 1) && (long)bucket.get(bucketPos + 1) - nums[i] <= value) {
                return true;
            }
        }
        return false;
    }


}
