package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/9/1.
 * https://leetcode.com/problems/implement-strstr/
 * This problem asked to implement str.indexOf(pattern) function
 */
public class l28StrStr {

    // get source.indexOf(target)
    public int strStr2(String source, String target) {
        for (int i = 0; true; i++) {
            for (int j = 0; true; j++) {
                if (j == target.length()) {
                    return i;
                }
                if (i + j == source.length()) {
                    return -1;
                }
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
        }
    }

    // kmp solution
    public static int strStr(String src, String pattern) {
        int[] next = getNext(pattern);
        int i = 0, j = 0;
        while (i < src.length() && j < pattern.length()) {
            if (src.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            else if (j != 0) {
                j = next[j];
            }
            else {
                i++;
            }
        }
        return j == pattern.length() ? i - pattern.length() : -1;
    }

    public static int[] getNext(String str) {
        int[] next = new int[str.length()];
        int i = 0, j = 1;
        while (j < str.length() - 1) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j++;
                next[j] = i;
            }
            else if (i != 0) {
                i = 0;
            }
            else {
                j++;
            }
        }
        return next;
    }

}
