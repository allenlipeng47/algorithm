package com.pli.project.algorithm.ms;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/3/19.
 */
public class Strstr {

    public int strStr(String str, String sub) {
        int i = 0, j = 0;
        int[] next = getNext(sub);
        while (i < str.length()) {
            if (str.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
                if (j >= sub.length()) {
                    return i - j + 1;
                }
            }
            else if (i > 0) {
                j = next[j];
            }
            else {
                i++;
            }
        }
        return -1;
    }

    private static int[] getNext(String str) {
        int len = str.length();
        int[] next = new int[len];
        for (int i = 0, j = 1; j < len; j++, i++) {
            if (str.charAt(i) == str.charAt(j)) {
                next[j + 1] = i + 1;
            }
            else {
                i = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcxabcd";
        int[] next = getNext(str);
        System.out.println(Arrays.toString(next));
    }




}
