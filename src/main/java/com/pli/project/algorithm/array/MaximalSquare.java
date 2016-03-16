package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2015/12/12.
 * https://leetcode.com/problems/maximal-square/
 */
public class MaximalSquare {

    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0] == null || matrix[0].length <= 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] == '0' ? 0 : 1;
            ans = Math.max(ans, dp[i][0]);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] == '0' ? 0 : 1;
            ans = Math.max(ans, dp[0][i]);
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans * ans;
    }




    public static void main(String[] args) {
//        char[][] matrix = {
//                {'1', '0', '1', '0', '0'},
//                {'1', '0', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '0', '0', '1', '0'}
//        };
        char[][] matrix = {
                {'0', '0'}
        };
//        char[][] matrix = {
//                {'1', '1'},
//                {'1', '1'}
//        };
//        char[][] matrix = {
//                {1}
//        };
        System.out.println(maximalSquare(matrix));
    }

}