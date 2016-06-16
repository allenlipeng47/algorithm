package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/6/15.
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 */
public class CountNumberWithUniqueDigit {

    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int ans = 10, base = 9;
        for (int i = 2; i <= n && i <= 10; i++) {
            base = base * (9 - i + 2);
            ans += base;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(2));
    }

}
