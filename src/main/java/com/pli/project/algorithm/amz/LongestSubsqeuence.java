package com.pli.project.algorithm.amz;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/8/24.
 */
public class LongestSubsqeuence {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
//        Arrays.fill(dp, Integer.MAX_VALUE);
        int len = 0;
        for (int i : nums) {
            int index = Arrays.binarySearch(dp, 0, len, i);
            if (index < 0) {
                index = - (index + 1);
            }
            if (index == len) {
                len++;
            }
            dp[index] = i;
        }
        return len;
    }
}
