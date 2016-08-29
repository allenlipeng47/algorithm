package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/8/28.
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii/
 * dp[i][j] = min (i<=k<=j) { k + max(dp[i][k-1], dp[k+1][j]) }
 * The goal is to calculate dp[1][n]
 */
public class GuessNumberII {

    public static int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int delta = 1; delta < n + 1; delta++) {
            for (int i = 1; i + delta < n + 1; i++) {
                int j = i + delta;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            k + Math.max(i <= k - 1? dp[i][k - 1] : 0, k + 1 <= j ? dp[k + 1][j] : 0));
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        System.out.println(getMoneyAmount(4));
    }

}
