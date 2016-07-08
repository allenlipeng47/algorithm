package com.pli.project.algorithm.dp;

/**
 * Created by lipeng on 2016/7/7.
 */
public class DistinctSubsequence {

    public static int numDistinct(String S, String T) {
        int rowNum = T.length() + 1, colNum = S.length() + 1;
        int[][] dp = new int[rowNum][colNum];
        for (int i = 0; i < colNum; i++) {
            dp[0][i] = 1;
        }
        for (int row = 1; row < rowNum; row++) {
            for (int col = 1; col < colNum; col++) {
                dp[row][col] = dp[row][col - 1] + (S.charAt(col - 1) == T.charAt(row - 1) ? dp[row - 1][col - 1] : 0);
            }
        }
        return dp[rowNum - 1][colNum - 1];
    }


    public static void main(String[] args) {
        System.out.println(numDistinct("acdabefbc", "abec"));
    }
}
