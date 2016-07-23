package com.pli.project.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by lipeng on 2016/7/22.
 */
public class l132PalindromePartitioningII {

    // dfs solution. Similar to word break II
    public static int minCut2(String s) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("", 0);
        return minCutHelper(s, hm) - 1;
    }

    private static int minCutHelper(String s, HashMap<String, Integer> hm) {
        if (hm.containsKey(s)) {
            return hm.get(s);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            String subStr = s.substring(0, i + 1);
            if (isPalindrome(subStr, 0, i)) {
                min = Math.min(min, minCutHelper(s.substring(i + 1), hm) + 1);
            }
        }
        hm.put(s, min);
        return min;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // dp solution, O(n^3) time complexity
    public static int minCut3(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int delta = 1; delta < s.length(); delta++) {
            for (int i = 0; i + delta < s.length(); i++) {
                // calculate cut for dp[i][i + delta]
                if (s.charAt(i) == s.charAt(i + delta) && (delta <= 1 || dp[i + 1][i + delta - 1] == 0)) {  // check palindrome by dp[][]
                    dp[i][i + delta] = 0;
                    continue;
                }
                dp[i][i + delta] = delta + 1;
                for (int k = 0; k < delta; k++) {
                    dp[i][i + delta] = Math.min(dp[i][i + k] + dp[i + k + 1][i + delta] + 1, dp[i][i + delta]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    // dp solution. O(n^2) time complexity
    public static int minCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] cut = new int[s.length()];
        Arrays.fill(cut, Integer.MAX_VALUE);
        for (int j = 0; j < cut.length; j++) {
            for (int i = 0; i <= j; i++) {
                // check dp[i][j]. when i + 1 >= j this is for checking length less than or eqaul to 2. such as 'a', 'ab'
                dp[i][j] = s.charAt(i) == s.charAt(j) && (i + 1 >= j || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    // when i == 0, it means whole s[0...j] is a palindrome.
                    cut[j] = Math.min(cut[j], i == 0 ? 0 : cut[i - 1] + 1);
                }
            }
        }
        return cut[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
//        System.out.println("abcd".substring(2));
    }

}
