package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/11.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestBuySellStock {

    public int maxProfit(int[] prices) {
        int profit = 0, low = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < low) {
                low = price;
            }
            else {
                profit = Math.max(profit, price - low);
            }
        }
        return profit;
    }

}
