package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2016/6/26.
 * https://en.wikipedia.org/wiki/Maximum_subarray_problem
 * This is also called Kadane's algorithm. It is a traditional one!
 */
public class MaxSubarray {

    public static int maxSubArray(int []arr) {
        int max = arr[0], currMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(currMax + arr[i], arr[i]);
            max = Math.max(max, currMax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }

}
