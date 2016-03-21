package com.pli.project.algorithm.ms;

/**
 * Created by lipeng on 2016/3/19.
 */
public class StockCoolDown {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[] sell = new int[prices.length];
        int[] notsell = new int[prices.length];
        sell[1] = Math.max(prices[1] - prices[0], 0);
        for (int i = 2; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            sell[i] = Math.max(sell[i - 1] + diff, notsell[i - 2] + diff);
            notsell[i] = Math.max(sell[i - 1], notsell[i - 1]);
        }
        return Math.max(sell[prices.length - 1], notsell[prices.length - 1]);
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        StockCoolDown stock = new StockCoolDown();
        System.out.println(stock.maxProfit(prices));
    }

}
