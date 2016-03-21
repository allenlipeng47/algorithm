package com.pli.project.algorithm.ms;

/**
 * Created by lipeng on 2016/3/18.
 */
public class BalanceIndex {

    public int findBalancePoint(int[] arr) {
        int lo = 0, hi = arr.length - 1, sumLeft = 0, sumRight = 0;
        while (lo < hi) {
            if (sumLeft < sumRight) {
                sumLeft += arr[lo++];
            }
            else {
                sumRight += arr[hi--];
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1};
        BalanceIndex balanceIndex = new BalanceIndex();
        System.out.println(balanceIndex.findBalancePoint(arr));
    }
}
