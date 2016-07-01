package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/7/1.
 * https://leetcode.com/problems/sum-of-two-integers/
 */
public class SumOfTwoIntegers {

    public static int getSum(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;    // to get the current sum
            b = (a & b) << 1;   // to get the carrier
            a = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getSum(5, -7));

    }
}
