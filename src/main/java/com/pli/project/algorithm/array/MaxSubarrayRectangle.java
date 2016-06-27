package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2016/6/26.
 * http://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/
 * This is a derivation from MaxSubarray problem.
 */
public class MaxSubarrayRectangle {

    public static int maxSubArrayRectangle(int [][]arr) {
        int row = arr.length, col = arr[0].length, max = arr[0][0];
        int[] helperArr = null;
        for (int left = 0; left < col; left++) {
            helperArr = new int[col];
            for (int right = left; right < col; right++) {
                // update helper
                for (int i = 0; i < row; i++) {
                    helperArr[i] += arr[i][right];
                }
                // Kodane algorithm to find the top and bottom for max continuous sequence
                int helperMax = helperArr[0], currHelperMax = helperArr[0];
                for (int i = 0; i < row; i++) {
                    currHelperMax = Math.max(currHelperMax + helperArr[i], helperArr[i]);
                    helperMax = Math.max(helperMax, currHelperMax);
                }
                max = Math.max(currHelperMax, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
        };
        System.out.println(maxSubArrayRectangle(arr));
    }

}
