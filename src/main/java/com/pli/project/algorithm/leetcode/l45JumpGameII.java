package com.pli.project.algorithm.leetcode;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/9/11.
 * https://leetcode.com/problems/jump-game-ii/
 */
public class l45JumpGameII {

    // dp O(n^2) solution. But exceeds time limit.
    public int jump2(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int step = 1; step <= nums[i]; step++) {
                if (i + step >= nums.length) {
                    break;
                }
                dp[i + step] = Math.min(dp[i + step], 1 + dp[i]);
            }
        }
        return dp[nums.length - 1];
    }

    public static int jump(int[] A) {
        int currLong = 0, nextLong = 0, level = 0;
        for (int i = 0; i < A.length; i++) {
            if (i - 1 == currLong) {
                level++;
                currLong = nextLong;
            }
            nextLong = Math.max(nextLong, A[i] + i);
        }
        return level;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 1, 1, 4};
        System.out.println(jump(A));
    }
}
