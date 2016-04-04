package com.pli.project.algorithm.dp;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/1/5.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class BuyStockV {

    public static int maxProfitNSquare(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][n];
        for(int i = 1; i < n; i++)
            dp[i - 1][i] = Math.max(0, prices[i] - prices[i - 1]);
        for(int delta = 2; delta < n; delta++)
            for(int i = 0; i < n - delta; i++) {
                int left = i, right = i + delta;
                dp[left][right] = Math.max(dp[left][right - 1], dp[left + 1][right]);
                for(int k = left + 1; k < right; k++)
                    dp[left][right] = Math.max(dp[left][right], dp[left][k - 1] + dp[k + 1][right]);
            }
        return dp[0][n - 1];
    }

    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0;
        int n = prices.length;
        int[] sell = new int[n],  notsell = new int[n];
        sell[1] = prices[1] - prices[0];
        for(int i = 2; i < n; i++) {
            /** sell at ith time. If at i-1 time already sold, then buy at i-1 time and sell at ith time.
            Or if i-1 time hasn't sold, we only bought from i-1 time. Last time it sold is before i-1.
            Because there is one time cooldown. it should add max val at i-2 time when it was not sold. */
            sell[i] = Math.max(prices[i] - prices[i - 1] + sell[i - 1], prices[i] - prices[i - 1] + notsell[i - 2]);
            /* not sell at ith time, then max val of not sell at ith time equals either it is sold at i-1 time or we don't sell at i-1 time */
            notsell[i] = Math.max(sell[i - 1], notsell[i - 1]);
        }
        return Math.max(sell[n - 1], notsell[n - 1]);
    }

    public static void main(String[] args) {
//        int[] prices = { 1, 5, 1, 3};
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }

}
