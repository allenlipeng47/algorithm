package com.pli.project.algorithm.dp;

/**
 * Created by lipeng on 2016/1/3.
 */
public class BurstBalloon {

    public static int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        arr[0] = arr[arr.length - 1] = 1;
        for (int i = 1; i < arr.length - 1; i++) {
            arr[i] = nums[i - 1];
        }
        int[][] dp = new int[arr.length][arr.length];
        for (int delta = 2; delta <= arr.length; delta++) {
            for (int i = 0; i < arr.length - delta; i++) {
                // calculate dp[i][i + delta]
                int left = i, right = left + delta;
                int max = Integer.MIN_VALUE;
                for (int k = left + 1; k <= right - 1; k++) {
                    int curr = dp[left][k] + dp[k][right] + arr[left] * arr[k] * arr[right];
                    max = Math.max(max, curr);
                }
                dp[left][right] = max;
            }
        }
        return dp[0][arr.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        System.out.println(maxCoins(nums));
    }


}
