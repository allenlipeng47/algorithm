package com.pli.project.algorithm.leetcode;

import java.util.HashMap;

/**
 * Created by lipeng on 2016/5/1.
 * leetcode 325: Maximum Size Subarray Sum Equals k
 * http://www.cnblogs.com/EdwardLiu/p/5104280.html
 */
public class MaximumSizeSubarraySumEqualsK {

    public static int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = Integer.MIN_VALUE, sum = 0;
        hm.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            }
            if (hm.containsKey(sum - k)) {
                max = Math.max(max, i - hm.get(sum - k));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        System.out.println(maxSubArrayLen(nums, 3));
    }

}
