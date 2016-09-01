package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/8/31.
 * https://leetcode.com/problems/longest-common-prefix/
 * Loop from position 0 to len.
 * 'abcde'
 * 'abcdefg'
 * 'abc'
 *
 * 'abcde'
 * 'abcdefg'
 * 'aba'
 */
public class l14LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0 || strs[0] == null || strs[0].length() == 0) {
            return "";
        }
        int i = 0;
        for (; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"a", "a"}));
        System.out.println(longestCommonPrefix(new String[]{"aa", "a"}));
    }

}
