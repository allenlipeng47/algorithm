package com.pli.project.algorithm.dp;

/**
 * Created by lipeng on 2015/10/17.
 */
public class BuyStockIV {

    public static int getMaxProfit2(int[] arr, int k) {
        if(arr==null || arr.length<2) {
            return 0;
        }
        int[] local = new int[k+1];
        int[] global = new int[k+1];
        for(int i=1; i<arr.length; i++) {
            int diff = arr[i] - arr[i-1];
            for(int j=k; j>0; j--) {
                local[j] = Math.max(local[j] + diff, global[j-1]+Math.max(diff, 0));
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[k];
    }

    public static void main(String[] args) {
//        int[] arr = {1, 3, 2, 4, 5, 6, 3, 4};
//        int[] arr = {1};
//        int[] arr = {0,3,2,1};
//        int[] arr = {0, 3, 3, 2, 6, 5};
        int[] arr = {3,3,5,0,0,3,1,4};
        System.out.println(getMaxProfit2(arr, 2));
    }

    public static int getMaxProfit(int[] arr, int k) {
        int[][] local = new int[arr.length][k+1];
        int[][] global = new int[arr.length][k+1];
        for(int i=1; i<arr.length; i++) {
            int diff = arr[i] - arr[i-1];
            for(int j=1; j<k+1; j++) {
                local[i][j] = Math.max(global[i-1][j-1] + Math.max(0, diff), local[i-1][j] + diff);
                global[i][j] = Math.max(local[i][j], global[i-1][j]);
            }
        }
        return global[arr.length-1][k];
    }

}
