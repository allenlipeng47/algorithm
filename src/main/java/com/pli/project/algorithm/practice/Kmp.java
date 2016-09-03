package com.pli.project.algorithm.practice;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/9/2.
 */
public class Kmp {

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

    public static void main(String[] args) {
        String str = "abcdddabce";
        System.out.println(strStr(str, "da"));
    }


}
