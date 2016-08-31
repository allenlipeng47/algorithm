package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/8/30.
 * https://leetcode.com/problems/regular-expression-matching/
 * http://www.allenlipeng47.com/blog/index.php/2015/12/18/regular-expression-dp-solution/
 */
public class l10RegularExpression {

    public static boolean isMatch(String s, String p) {
        s = "$" + s;
        p = "$" + p;
        boolean[][] dp = new boolean[p.length()][s.length()];
        dp[0][0] = true;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '.') {
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
                while (j < s.length()) {
                    dp[i][j] = dp[i - 1][j] || (i >= 2 && dp[i - 2][j]);
                    if (!dp[i][j++]) {
                        continue;
                    }
                    while (j < s.length()) {
                        if (p.charAt(i - 1) != s.charAt(j) && p.charAt(i - 1) != '.') {
                            break;
                        }
                        dp[i][j++] = true;  // when p[i - 1] == s[j] or p[i - 1] is '.'
                    }
                }   // while
            }
        }
        return dp[p.length() - 1][s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("aa", ".*"));
        System.out.println(isMatch("abcd", "d*"));
    }


}
