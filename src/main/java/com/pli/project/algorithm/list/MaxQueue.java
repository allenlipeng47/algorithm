package com.pli.project.algorithm.list;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by lipeng on 2016/1/29.
 */
public class MaxQueue {

    public static class MaxMinQueue {
        LinkedList<Integer> queue;
        LinkedList<Integer> maxList;

        public MaxMinQueue() {
            queue = new LinkedList<Integer>();
            maxList = new LinkedList<Integer>();
        }

        public void enQueue(int e) {
            while (!maxList.isEmpty() && maxList.getLast() < e) {
                maxList.pollLast();
            }
            maxList.addLast(e);
            queue.addLast(e);
        }

        public int deQueue() {
            int ele = queue.pollFirst();
            if (!maxList.isEmpty() && ele == maxList.getFirst()) {
                maxList.pollFirst();
            }
            return ele;
        }

        public int getMax() {
            return maxList.getFirst();
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <=0) {
            return new int[]{};
        }
        MaxMinQueue queue = new MaxMinQueue();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < k && i < n; i++) {
            queue.enQueue(nums[i]);
        }
        ans[0] = queue.getMax();
        for (int i = k; i < n; i++) {
            queue.enQueue(nums[i]);
            queue.deQueue();
            ans[i - k + 1] = queue.getMax();

        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7}; int k = 3;
        int[] nums = {7, 2, 4}; int k = 2;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

}
