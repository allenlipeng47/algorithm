package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/8/12.
 * https://leetcode.com/problems/powx-n/
 */
public class PowXN {

    public double myPow(double x, int n) {
        long logN = Math.abs((long)n);  // use long type, in case an input is pow(2, -2147483648). n is greater than MaxInt
        double ans = 1;
        while (logN > 0) {
            if ((logN & 1) == 1) {
                ans = ans * x;
            }
            x = x * x;
            logN = logN >> 1;
        }
        return n > 0 ? ans : 1 / ans;
    }


}




