package com.pli.project.algorithm.dp;

import java.util.Arrays;

/**
 * Created by lipeng on 2015/12/1.
 * Given a set of coins and a bill val, use minimum number of coins to consist of number.
 * For example, coin = {1, 2, 5}, bill=11. the minimum coins is 5+5+1=11, 3 coins
 * coin = {1, 2, 5}, bill=11, the minimum coins is 1+1+1+1+1+1+1+1+1+1+1=11, 11 coins
 * coin = {2, 5, 7}, bill=11, there is no result, return -1
 * coin = {2, 5, 7}, bill=10, minimum is 2+2+2+2+2=10, 5 coins
 */
public class MinimumCoins {

    public static int getMinimumCoins(int[] coin, int bill) {
        assert(coin!=null&&coin.length>0);
        int[] rec = new int[bill+1];
        Arrays.sort(coin);
        for(int i=1; i<rec.length; i++) {
            if(i%coin[0]==0) {
                rec[i] = i/coin[0];
            }
            else {
                rec[i] = -1;
            }
        }
        for(int i=1; i<coin.length; i++) {
            for(int j=coin[i]; j<rec.length; j++) {
                if(rec[j-coin[i]]!=-1) {
                    rec[j] = 1 + rec[j-coin[i]];
                }
            }
        }
        return rec[rec.length-1];
    }

    public static void main(String[] args) {
//        int[] coin = {1, 2, 5};
        int[] coin = {2, 5, 7};
        System.out.println(getMinimumCoins(coin, 10));
    }
}