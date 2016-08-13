package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created by lipeng on 2016/8/12.
 */
public class SlidingWindowMaximumSlidingWindowMaximumTest {

    @Test
    public void test1() {
        SlidingWindowMaximumSlidingWindowMaximum s = new SlidingWindowMaximumSlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] ans = s.maxSlidingWindow(nums, 3);
        assert ans[0] == 3;
        assert ans[1] == 3;
        assert ans[2] == 5;
        assert ans[3] == 5;
        assert ans[4] == 6;
        assert ans[5] == 7;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k];
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
