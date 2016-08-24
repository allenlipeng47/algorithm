package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/23.
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class MyAtoi {

    public int myAtoi(String str) {
        int i = 0, sign = 1, ans = 0;
        // 1. Skip initial space
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        // 2. get the sign
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = str.charAt(i) == '+' ? 1 : -1;
            i++;
        }
        // 3. get the ans
        while (i < str.length()) {
            char ch = str.charAt(i);
            if (ch < '0' || ch > '9') {
                break;
            }
            ans = ans * 10 + (ch - '0');
            if (Integer.MAX_VALUE / 10 < ans || (Integer.MAX_VALUE / 10 == ans && Integer.MAX_VALUE % 10 < (ch - 'a'))) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++;
        }
        return ans * sign;
    }

}
