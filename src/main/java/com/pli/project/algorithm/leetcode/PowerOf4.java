package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/4/18.
 */
public class PowerOf4 {

    public static boolean isPowerOfFour(int num) {
        return (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(1));

    }
}
