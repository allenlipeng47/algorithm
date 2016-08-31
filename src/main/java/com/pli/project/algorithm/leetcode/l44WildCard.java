package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/8/30.
 */
public class l44WildCard {

    public static boolean isMatch(String s, String p) {
        s = "$" + s;
        p = "$" + p;
        boolean[][] dp = new boolean[p.length()][s.length()];
        dp[0][0] = true;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '?') {
                for (int j = 1; j < s.length(); j++) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
            else if (p.charAt(i) != '*') {
                for (int j = 1; j < s.length(); j++) {
                    dp[i][j] = dp[i - 1][j - 1] && p.charAt(i) == s.charAt(j);
                }
            }
            else {
                for (int j = 0; j < s.length(); j++) {
                    dp[i][j] = dp[i - 1][j] || (j > 0 && dp[i][j - 1]);
                }
            }
        }
        return dp[p.length() - 1][s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "*"));
        System.out.println(isMatch("ab", "?*"));
        System.out.println(isMatch("", "*"));
        System.out.println(isMatch("a", "*"));
    }

}
