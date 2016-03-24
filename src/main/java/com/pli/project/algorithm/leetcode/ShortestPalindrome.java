package com.pli.project.algorithm.leetcode;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/3/23.
 */
public class ShortestPalindrome {

    public String shortestPalindrome(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        int i = 0, j = str.length() - 1, ans = 0;
        int[] next = getNext(str);
        while (j >= 0) {
            if (str.charAt(i) == str.charAt(j)) {
                ans++;
                i++;
                j--;
            }
            else if (next[i] > 0) {
                i = ans = next[i];
            }
            else {
                j--;
                ans = 0;
                i = 0;
            }
        }
        return new StringBuffer(str.substring(ans, str.length())).reverse() + str;
    }

    public int[] getNext(String str) {
        int[] next = new int[str.length()];
        int i = 0, j = 1, len = str.length(), count = 0;
        while (j < len - 1) {
            if (str.charAt(i) == str.charAt(j)) {
                count++;
                next[j + 1] = count;
                i++;
                j++;
            }
            else if (i > 0) {
                i = 0;
                count = 0;
            }
            else {
                next[j + 1] = 0;
                j++;
                count = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        ShortestPalindrome s = new ShortestPalindrome();
//        String str = "abcd";
//        String str = "adcba";
        String str = "ab";
//        int[] next = s.getNext(str);
        System.out.println(s.shortestPalindrome(str));

    }

}
