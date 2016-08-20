package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.exercise2014.IntegerSet;

/**
 * Created by lipeng on 2016/8/20.
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

    public int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x = -x;
        }
        int ans = 0;
        while (x > 0) {
            if (Integer.MAX_VALUE / 10 < ans) { // ignore the overflow value.
                return 0;
            }
            int low = x % 10;
            ans = ans * 10 + low;
            x /= 10;
        }
        return ans * sign;
    }

}
