package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/7/6.
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        StringBuffer[] sbs = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuffer();
        }
        int i = 0, len = s.length();
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++, i++) {   // build vertical part
                sbs[idx].append(s.charAt(i));
            }
            for (int idx = numRows - 2; idx >= 1 && i < len; idx--, i++) {  // build oblique part
                sbs[idx].append(s.charAt(i));
            }
        }
        for (int j = 1; j < numRows; j++) {
            sbs[0].append(sbs[j]);
        }
        return sbs[0].toString();
    }

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        System.out.println(convert(str, 3));
    }

}
