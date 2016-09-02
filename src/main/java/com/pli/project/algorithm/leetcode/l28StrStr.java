package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/9/1.
 * https://leetcode.com/problems/implement-strstr/
 * This problem asked to implement str.indexOf(pattern) function
 */
public class l28StrStr {

    // get source.indexOf(target)
    public int strStr(String source, String target) {
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

}
