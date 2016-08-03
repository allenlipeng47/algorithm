package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/8/2.
 */
public class l96UniqueBst {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }


}
