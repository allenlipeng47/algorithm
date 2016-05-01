package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/4/30.
 */
public class Atoi {

    public static int myAtoi(String str) {
        int index = 0, ans = 0, sign = 1, len = str.length();
        while (index < len && str.charAt(index) == ' ') {
            index++;
        }
        if (index < len && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
            sign = str.charAt(index++) == '-' ? -1 : 1;
        }
        while (index < len) {
            char ch = str.charAt(index);
            if (ch < '0' || ch > '9') {
                break;
            }
            int base = ch - '0';
            if (Integer.MAX_VALUE / 10 < ans || Integer.MAX_VALUE / 10 == ans && Integer.MAX_VALUE % 10 <= base) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + base;
            index++;
        }
        return ans * sign;
    }

}
