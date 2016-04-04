package com.pli.project.algorithm.numbertheory;

/**
 * Created by lipeng on 2016/1/23.
 */
public class UglyNumber {

    public static boolean isUgly(int num) {
        return isUgly(num, new int[] {2, 3, 5});
    }

    public static boolean isUgly(int num, int[] primes) {
        if (num == 0)
            return false;
        int n = primes.length;
        for (int i = 0; i < n; i++) {
            while (num % primes[i] == 0)
                num /= primes[i];
        }
        if (num == 1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(0));
    }


}
