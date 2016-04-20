package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2016/4/19.
 */
public class InterBreak {

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= i / 2 + 1; j++) {
                int leftMax = Math.max(j, dp[j]);
                int rightMax = Math.max(i - j, dp[i - j]);
                max = Math.max(max, leftMax * rightMax);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(integerBreak(n));

    }


}
