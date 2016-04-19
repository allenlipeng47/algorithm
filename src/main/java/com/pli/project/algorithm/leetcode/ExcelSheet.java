package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/4/18.
 */
public class ExcelSheet {

    public static String convertToTitle(int n) {
        StringBuffer ans = new StringBuffer();
        while (n > 0) {
            n--;
            int remaining = n % 26;
            ans.insert(0, (char)('A' + remaining));
            n /= 26;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(26));
    }

}
