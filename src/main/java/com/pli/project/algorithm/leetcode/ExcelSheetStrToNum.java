package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/4/18.
 * https://leetcode.com/problems/excel-sheet-column-number/
 * From string to number, calculate from left to right.
 */
public class ExcelSheetStrToNum {

    public static int titleToNumber(String s) {
        int len = s.length(), ans = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            ans = ans * 26 + (ch - 'A' + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "AB";
        System.out.println(titleToNumber(str));
    }


}
