package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2015/12/27.
 * 322. Coin Change
 */
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length<1)
            return -1;
        int[] arr = new int[amount+1];
        for(int i=1; i<arr.length; i++)
            arr[i] = -1;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==-1)
                continue;
            for(int j=0; j<coins.length; j++) {
                if(i+coins[j]>=arr.length)
                    continue;
                int targetPos = i + coins[j];
                if(arr[targetPos]==-1 || arr[targetPos]>arr[i]+1)
                    arr[targetPos] = arr[i] + 1;
            }
        }
        return arr[amount];
    }

    public static void main(String[] args) {
        int[] coins = {474, 3, 404, 83};
        int amount = 264;
        System.out.println(coinChange(coins, amount));
    }


}
