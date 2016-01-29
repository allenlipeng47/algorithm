package com.pli.project.algorithm.numbertheory;

/**
 * Created by lipeng on 2016/1/24.
 * https://leetcode.com/problems/add-digits/
 */
public class DigitalRoot {

    // bascially, return the modular 9 of num. But we need to exclude 2 exceptions:
    // 1. when num is 0. return 0
    // 2. when modular is 0, should return 0;
    // eaiest one is return num - (num - 1) / 9 * 9
    public static int addDigits(int num) {
        if (num == 0)
            return 0;
        int mod = num % 9;
        if (mod == 0)
            return 9;
        else
            return mod;
    }

}
