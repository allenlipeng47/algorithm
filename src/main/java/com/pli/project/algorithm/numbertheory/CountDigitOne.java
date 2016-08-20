package com.pli.project.algorithm.numbertheory;

/**
 * Created by lipeng on 2016/2/6.
 * https://leetcode.com/problems/number-of-digit-one/
 */
public class CountDigitOne {

    public static int countDigitOne(int n) {
        if (n <=0) {
            return 0;
        }
        int len = (int)Math.log10(n) + 1;
        int left, right, mid, tmp, ans = 0;
        for (int i = 0, unit = 1; i < len; i++, unit *= 10) {
            tmp = n / unit;
            left = tmp / 10;
            mid = tmp - tmp / 10 * 10;
            right = n - tmp * unit;
            ans += left * unit;
            if (mid > 1) {
                ans += unit;
            }
            else if (mid == 1) {
                ans += right + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(countDigitOne(3210));
    }

}
