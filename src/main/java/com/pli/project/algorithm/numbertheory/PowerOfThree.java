package com.pli.project.algorithm.numbertheory;

/**
 * Created by lipeng on 2016/1/10.
 * https://leetcode.com/discuss/78735/two-ways-and-o-1
 * Other solutions:
 * return (n == 1 || n == 3 || n == 9 || n == 27 || n == 81 || n == 243 || n == 729 || n == 2187 || n == 6561 || n == 19683 || n == 59049 || n == 177147 || n == 531441 || n == 1594323 || n == 4782969 || n == 14348907 || n == 43046721 || n == 129140163 || n == 387420489 || n == 1162261467);
 * return n>0?!(1162261467 % n):0;
 */
public class PowerOfThree {

    public static boolean isPowerOfThree(int n) {
        while (n >= 3) {
            if (n % 3 != 0)
                return false;
            n /= 3;
        }
        if (n == 1)
            return true;
        else
            return false;
    }

}
