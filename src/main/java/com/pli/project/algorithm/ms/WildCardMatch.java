package com.pli.project.algorithm.ms;

/**
 * Created by lipeng on 2016/3/20.
 */
public class WildCardMatch {

    public static boolean isMatch(String s, String p) {
        s = "$" + s;
        p = "$" + p;
        boolean[][] dp = new boolean[p.length()][s.length()];
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
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
                int j = 0;
                while (j < s.length() && !dp[i - 1][j]) {
                    j++;
                }
                while (j < s.length()) {
                    dp[i][j] = true;
                    j++;
                }
            }
        }
        return dp[p.length() - 1][s.length() - 1];
    }


    public static void main(String[] args) {
        String str = "aaa";
        String reg = "*a";
        System.out.println(isMatch(str, reg));
    }


}
