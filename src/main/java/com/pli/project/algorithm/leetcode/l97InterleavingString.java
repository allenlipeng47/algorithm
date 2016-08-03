package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/8/2.
 * https://leetcode.com/problems/interleaving-string/
 */
public class l97InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s3.charAt(i)) {
                break;
            }
            dp[i + 1][0] = true;
        }
        for (int j = 0; j < s2.length(); j++) {
            if (s2.charAt(j) != s3.charAt(j)) {
                break;
            }
            dp[0][j + 1] = true;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // should pay attention that it is i + j - 1, not i + j - 2
                dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                        || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

}
