package com.pli.project.algorithm.string;

/**
 * Created by lipeng on 2016/7/8.
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseString {


    // in-place solution
    public static String reverseWords(String s) {
        char[] chs = s.trim().toCharArray();
        reverse(chs, 0, chs.length - 1);
        int start = 0, end = 0;
        while (start < chs.length) {
            for (end = start; end < chs.length && chs[end] != ' '; end++);
            reverse(chs, start, end - 1);
            start = end + 1;
        }
        return new String(chs);
    }

    public static void reverse(char[] chs, int start, int end) {
        while (start < end) {
            char tmp = chs[start];
            chs[start] = chs[end];
            chs[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  a  b"));
    }


}
