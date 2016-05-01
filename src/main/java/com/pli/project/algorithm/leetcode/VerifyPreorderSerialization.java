package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/4/30.
 */
public class VerifyPreorderSerialization {

    public static boolean isValidSerialization(String preorder) {
        String[] str = preorder.split(",");
        int n = 1;
        for (int i = 0; i < str.length; i++) {
            if (--n < 0) {
                return false;
            }
            if (!str[i].equals("#")) {
                n += 2;
            }
        }
        return n == 0;
    }

}
