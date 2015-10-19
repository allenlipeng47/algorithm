package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2015/10/17.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BuyStockII {

    public static  int maxProfit(int[] prices) {
        if(prices==null || prices.length<2) {
            return 0;
        }
        int maxProfit = 0;
        int start = 0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i]<prices[i-1]) {
                maxProfit = maxProfit + (prices[i-1] - prices[start]);
                start = i;
            }
        }
        if(prices[prices.length-1] > prices[start]) {
            maxProfit = maxProfit + (prices[prices.length-1]-prices[start]);
        }
        return maxProfit;
    }


    public static void main(String[] args) {
//        int[] arr = {1, 3, 2, 4, 5, 6, 3, 4};
//        int[] arr = {1};
//        int[] arr = {0,3,2,1};
        int[] arr = {0, 3, 3, 2, 6, 5};
//        int[] arr = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(arr));
    }

}
