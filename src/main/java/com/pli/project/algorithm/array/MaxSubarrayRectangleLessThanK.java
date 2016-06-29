package com.pli.project.algorithm.array;

import java.util.TreeSet;

/**
 * Created by lipeng on 2016/6/26.
 * https://leetcode.com/problems/max-sum-of-sub-matrix-no-larger-than-k/
 * This is a derivation from MaxSubarray Rectangle problem.
 */
public class MaxSubarrayRectangleLessThanK {

    public static int maxSubArrayRectangleLessThanK(int [][]matrix, int k) {
        int ans = Integer.MIN_VALUE, row = matrix.length, col = matrix[0].length;
        for (int left = 0; left < col; left++) {
            int[] helper = new int[row];
            for (int right = left; right < col; right++) {
                for (int i = 0; i < helper.length; i++) {
                    helper[i] += matrix[i][right];
                }
                int sumRight = 0;
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);  // this is important. without this, won't pass {1, 0}
                for (int i : helper) {
                    sumRight += i;
                    Integer sumLeft = ts.ceiling(sumRight - k);
                    if (sumLeft != null) {
                        ans = Math.max(ans, sumRight - sumLeft);
                    }
                    ts.add(sumRight);
                }   // for
            }   // for
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[][] arr = {
//                {1, 2, -1, -4, -20},
//                {-8, -3, 4, 2, 1},
//                {3, 8, 10, 1, 3},
//                {-4, -1, 1, 7, -6}
//        };
        int[][] arr = {
                {1, 0, 1},
                {0, -2, 3}
        };
        System.out.println(maxSubArrayRectangleLessThanK(arr, 2));
    }

}
