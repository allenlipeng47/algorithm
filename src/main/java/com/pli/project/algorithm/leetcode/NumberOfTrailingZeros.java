package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/4/16.
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 * We can know that 0 only happens when there is factor 5 and factor 2. Because factor 2 is ample.
 * So we count how many factor 5 there is from 1, 2, 3, ... , n
 * If n = 5. 1, 2, 3, 4, 5. there is 1 five.
 * If n = 11. 1, 2, 3, 4, 5, 6, 7, 8, 9, 10(5 * 3), 11. there are 2 five
 * If n = 25. 1, 2, 3, 4, 5, 6, 7, 8, 9, 10(5 * 2), 11, 12, 13, 14, 15(5 * 3), 16, 17, 18, 19, 20(5 * 4), 21, 22, 23, 24, 25(5 * 5).
 * There are 6 fives.
 */
public class NumberOfTrailingZeros {

    public int trailingZeroes(int n) {
        return n <= 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

}
