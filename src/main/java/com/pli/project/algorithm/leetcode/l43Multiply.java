package com.pli.project.algorithm.leetcode;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/8/29.
 * https://leetcode.com/problems/multiply-strings/
 */
public class l43Multiply {

    public String multiply(String num1, String num2) {
        int[] digit = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int posHigh = i + j, posLow = i + j + 1;
                int curr = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + digit[posLow];
                digit[posLow]  = curr % 10;
                digit[posHigh] += curr / 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i : digit) {
            if (!(sb.length() == 0 && i == 0)) {
                sb.append(i);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

}
