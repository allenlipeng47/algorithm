package com.pli.project.algorithm.array;

import java.util.TreeSet;

/**
 * Created by lipeng on 2016/6/26.
 * This is a followup of MaxSubarray. It requires to find the max continuous subarray but the sum is less than or equal to k.
 * The solution is to use TreeSet. Iterate the element in array, and save the sum[0, ..., i] in TreeSet.
 * When it is for element i, try to find TreeSet.ceil(i - k). sum(i - k, i - k + 1, ..., i) could be the answer.
 */
public class MaxSubarrayLessThanK {

    public static int maxSubArrayLessThanK(int []arr, int k) {
        int ans = Integer.MIN_VALUE, sumRight = 0;
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i : arr) {
            sumRight += i;
            Integer sumLeft = ts.ceiling(sumRight - k);
            if (sumLeft != null) {
               ans = Math.max(ans, sumRight - sumLeft);
            }
            ts.add(sumRight);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArrayLessThanK(arr, 0));
    }

}
