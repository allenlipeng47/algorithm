package com.pli.project.algorithm.dp;

/**
 * Created by pli on 1/4/2016.
 * https://leetcode.com/problems/burst-balloons/
 * Use dp to solve this problem.
 */
public class BollanBurst {

    public static int getMaxNum(int[] num) {
        int[] arr = new int[num.length + 2];    // build up arr, which has 1 on each side to enclose.
        int n = arr.length;
        arr[0] = 1; arr[n - 1] = 1;
        for(int i = 1; i < n - 1; i++)
            arr[i] = num[i - 1];
        int[][] dp = new int[n][n];
        for(int i = 0; i < n - 2; i++)
            dp[i][i + 2] = arr[i] * arr[i + 1] * arr[i + 2];
        for(int delta = 3; delta < n; delta++)
            for(int i = 0; i < n - delta; i++) {
                int left = i, right = i + delta;
                for(int k = left + 1; k < right; k++) {
                    int curr = dp[left][k] + dp[k][right] + arr[left] * arr[k] * arr[right];
                    dp[left][right] = curr > dp[left][right] ? curr : dp[left][right];
                }   // for k loop
            }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 8};
        System.out.println(getMaxNum(arr));
    }

}
