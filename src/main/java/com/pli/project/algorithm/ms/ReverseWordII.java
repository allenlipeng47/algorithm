package com.pli.project.algorithm.ms;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/3/17.
 */
public class ReverseWordII {

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        for (int start = 0, end = start + 1; start < s.length && end < s.length; end++) {
            if (end == s.length - 1 || s[end + 1] == ' ') {
                reverse(s, start, end);
                start = end + 2;
            }
        }
    }

    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseWordII r = new ReverseWordII();
        char[] chs = "the skye is blue".toCharArray();
        r.reverseWords(chs);
        System.out.println(Arrays.toString(chs));
    }


}
