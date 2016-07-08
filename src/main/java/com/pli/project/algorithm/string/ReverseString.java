package com.pli.project.algorithm.string;

/**
 * Created by lipeng on 2016/7/8.
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseString {

    public static String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < strs.length - 1; i++) {
            ans.append(strs[i] + " ");
        }
        ans.append(strs.length > 0 ? strs[strs.length - 1] : "");
        return ans.toString();
    }

    // in-place solution
    public static char[] reverseWords2(char[] chs) {
        reverse(chs, 0, chs.length - 1);
        int start = 0, end = 0;
        while (start < chs.length) {
            for (end = start + 1; end < chs.length && chs[end] != ' '; end++);
            reverse(chs, start, end - 1);
            end++;
            start = end;
        }
        return chs;
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
        System.out.println(reverseWords2("the sky is  blue".toCharArray()));
        System.out.println(reverseWords("the sky is blue"));
    }


}
