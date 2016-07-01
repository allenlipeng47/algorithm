package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2016/6/30.
 * https://leetcode.com/problems/valid-perfect-square/
 * If n is a valid perfect square, n = 1 + 3 + 5 + 7 + ...
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        int delta = 1;
        while (num > 0) {
            num -= delta;
            delta += 2;
        }
        return num == 0;
    }

}
