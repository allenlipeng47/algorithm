package com.pli.project.algorithm.practice;

/**
 * Created by lipeng on 2016/8/9.
 * https://leetcode.com/problems/interleaving-string/
 */
public class InterLeaving {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < s1.length(); i++) {
            if (!dp[i][0]) {
                break;
            }
            dp[i + 1][0] = s1.charAt(i) == s3.charAt(i);
        }
        for (int i = 0; i < s2.length(); i++) {
            if (!dp[0][i]) {
                break;
            }
            dp[0][i + 1] = s2.charAt(i) == s3.charAt(i);
        }
        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                dp[i + 1][j + 1] = dp[i][j + 1] && s1.charAt(i) == s3.charAt(i + j + 1)
                        || dp[i + 1][j] && s2.charAt(j) == s3.charAt(i + j + 1);
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
