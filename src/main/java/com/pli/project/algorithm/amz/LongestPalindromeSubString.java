package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/10.
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromeSubString {

    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            int len = 1, left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > ans.length()) {
                    ans = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > ans.length()) {
                    ans = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return ans;
    }

}
