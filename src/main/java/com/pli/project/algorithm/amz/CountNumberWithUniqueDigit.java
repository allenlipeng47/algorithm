package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/24.
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 */
public class CountNumberWithUniqueDigit {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int ans = 10, base = 9;
        for (int i = 2; i <= 10 && i <= n; i++) {
            base *= 11 - i;
            ans += base;
        }
        return ans;
    }

}
