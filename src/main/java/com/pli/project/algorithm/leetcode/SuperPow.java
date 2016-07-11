package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/7/8.
 * https://leetcode.com/problems/super-pow/
 * A math problem solved by remainder multiplication rules.
 */
public class SuperPow {

    public static int DIV = 1337;

    public static int superPow(int a, int[] b) {
        return superPowHelper(a % DIV, b, b.length - 1);
    }

    public static int superPowHelper(int a, int[] b, int pos) {
        if (pos <= 0) {
            return pow(a, b[0]);
        }
        int next = superPowHelper(a, b, pos - 1);
        return ((pow(next, 10) % DIV) * (pow(a, b[pos]) % DIV)) % DIV;
    }

    public static int pow(int a, int b) {
        int ans = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                ans = (ans * a) % DIV;
            }
            a = (a * a) % DIV;
            b = b >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(superPow(2, new int[]{1, 0}));
    }


}
