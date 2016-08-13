package com.pli.project.algorithm.amz;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by lipeng on 2016/8/12.
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximumSlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] ans = new int[nums.length - k + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.getLast() < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
            if (i >= k && nums[i - k] == queue.getFirst()) {
                queue.removeFirst();
            }
            if (i >= k - 1) {
                ans[i - k + 1] = queue.getFirst();
            }
        }
        return ans;
    }

}
