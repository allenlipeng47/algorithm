package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/19.
 */
public class CountDigitOne {

    /*
    For n = 54321, k = 1, 10, 100, 1000, 10000
     when k = 100, should divide into 54, 3, 21
     l = 543,
     m = 543 % 100 = 3
     r = 54321 - 543 * 100 = 21
     l = 543 / 10 = 543
    */
    public int countDigitOne(int n) {
        int ans = 0;
        for (long k = 1; k <= n; k *= 10) {
            long left = n / k;
            long mid = left % 10;
            long right = n - left * k;
            left = left / 10;
            ans += left * k;
            if (mid > 1) {
                ans += k;
            }
            else if (mid == 1) {
                ans += right + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        countDigitOne(12345);
    }

}
