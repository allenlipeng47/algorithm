package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/23.
 */
public class ReverseWordInString {

    public String reverseWords(String s) {
        char[] chs = s.trim().toCharArray();
        for (int i = 0, j = 0; j <= chs.length; j++) {
            if (j == chs.length || chs[j] == ' ') {
                reverse(chs, i, j - 1);
                i = j + 1;
            }
        }
        reverse(chs, 0, chs.length - 1);
        return new String(chs);
    }

    private void reverse(char[] chs, int i, int j) {
        while (i < j) {
            char ch = chs[i];
            chs[i] = chs[j];
            chs[j] = ch;
            i++;
            j--;
        }
    }

}
