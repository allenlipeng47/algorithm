package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/9/1.
 * https://leetcode.com/problems/divide-two-integers/
 * The logic is to bit shift divisor until the max divisor when divisor is smaller than dividend,
 * but next shift will be greater than. And 1 << shift is the bit of this time calculation.
 *
 */
public class l29DivideTwoInteger {

    public static int divide(int dividend, int divisor) {
        if (divisor == 0 || divisor == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        int ans = 0, sign = dividend < 0 ^ divisor < 0 ? -1 : 1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend >= divisor) {
            int shift = 0;
            while (dividend >= (divisor << (shift + 1))) {
                shift++;
            }
            ans = ans | (1 << shift);
            dividend -= (divisor << shift);
        }
        return ans * sign;
    }

    public static void main(String[] args) {
        System.out.println(divide(60, -4));
        System.out.println(divide(72, 1));
    }
}
