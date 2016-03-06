package com.pli.project.algorithm.dp;

/**
 * Created by pli on 3/5/2016.
 * http://blueocean-penn.blogspot.com/2015/02/find-repeating-sub-sequences-in-string.html
 * A variation of LCS problem. The key is that if i==j, then don't count.
 */
public class LongestSubsequenceInString {

    public static int longestSubsequence(String str) {
        int len = str.length();
        int[][] dp = new int[len][len];
        for (int i = 1; i < len; i++) { // initial first row and first column
            if (str.charAt(0) == str.charAt(i)) {
                dp[0][i] = dp[i][0] = 1;
            }
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len; j++) {
                int curr = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (i != j && str.charAt(i) == str.charAt(j)) { // in classical LCS, it doesn't has str.charAt(i) == str.charAt(j)
                    curr++;
                }
                dp[i][j] = curr;
            }
        }
        return dp[len - 1][len - 1];
    }


    public static void main(String[] args) {
        String str = "aabcdbcd";
        System.out.println(longestSubsequence(str));
    }

}
