package com.pli.project.algorithm.dp;

/**
 * Created by lipeng on 2015/10/18.
 */
public class BuyStockIII {

    public static int maxProfit(int[] prices) {
        if(prices==null||prices.length<2) {
            return 0;
        }
        int[] maxLeft = new int[prices.length];
        for(int i=1, extreme=prices[0]; i<prices.length; i++) {
            if(prices[i]<extreme) {
                extreme = prices[i];
                maxLeft[i] = maxLeft[i-1];
            }
            else {
                int currMax = prices[i] - extreme;
                maxLeft[i] = Math.max(currMax, maxLeft[i-1]);
            }
        }
        int[] maxRight = new int[prices.length];;
        for(int i=prices.length-2, extreme=prices[prices.length-1]; i>0; i--) {
            if(prices[i]>extreme) {
                extreme = prices[i];
                maxRight[i] = maxRight[i+1];
            }
            else {
                int currMax = extreme - prices[i];
                maxRight[i] = Math.max(currMax, maxRight[i+1]);
            }
        }
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++) {
            maxProfit = Math.max(maxProfit, maxLeft[i]+maxRight[i]);
        }
        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        if(prices==null||prices.length<2) {
            return 0;
        }
        int[] maxLeft = new int[prices.length];
        for(int i=1, extreme=prices[0]; i<prices.length; i++) {
            if(prices[i]<extreme) {
                extreme = prices[i];
                maxLeft[i] = maxLeft[i-1];
            }
            else {
                int currMax = prices[i] - extreme;
                maxLeft[i] = Math.max(currMax, maxLeft[i-1]);
            }
        }
        int[] maxRight = new int[prices.length];
        int maxProfit = 0;
        for(int i=prices.length-2, extreme=prices[prices.length-1]; i>0; i--) {
            if(prices[i]<extreme) {
                extreme = prices[i];
//                maxRight[i] = maxRight[i+1];
            }
            else {
                int currMax = extreme - prices[i];
                maxRight[i] = Math.max(currMax, maxRight[i+1]);
            }
        }

        for(int i=0; i<prices.length; i++) {
            maxProfit = Math.max(maxProfit, maxLeft[i]+maxRight[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 3, 2, 4, 5, 6, 3, 4};
        int[] arr = {2,1,2,0,1};
        System.out.println(maxProfit(arr));
    }

}
