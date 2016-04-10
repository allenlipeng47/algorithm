package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/4/10.
 */
public class RangeBitWiseAnd {

    public int rangeBitwiseAnd(int m, int n) {
        int move = 0;
        while (m != n) {
            m = m >> 1;
            n = n >> 1;
            move++;
        }
        return m << move;
    }

    public static void main(String[] args) {

    }
}
