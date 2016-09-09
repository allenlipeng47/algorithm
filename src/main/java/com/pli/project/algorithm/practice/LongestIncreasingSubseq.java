package com.pli.project.algorithm.practice;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/9/8.
 */
public class LongestIncreasingSubseq {

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int size = 0;
        for (int i : nums) {
            int idx = Arrays.binarySearch(dp, 0, size, i);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            dp[idx] = i;
            if (idx == size) {
                size++;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }

}
