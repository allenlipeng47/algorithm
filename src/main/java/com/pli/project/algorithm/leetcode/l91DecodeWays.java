package com.pli.project.algorithm.leetcode;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/8/3.
 * dp[].
 */
public class l91DecodeWays {

    public static int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            int oneLetterNum = Integer.parseInt(s.substring(i, i + 1));
            if (oneLetterNum > 0) {
                dp[i + 1] += dp[i];
            }
            int twoLetterNum = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoLetterNum >= 10 && twoLetterNum <= 26) {
                dp[i + 1] += dp[i - 1];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12201"));
    }


}
