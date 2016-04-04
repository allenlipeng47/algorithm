package com.pli.project.algorithm.numbertheory;

/**
 * Created by lipeng on 2016/2/18.
 */
public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return n == (-n & n);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(8));
    }

}
