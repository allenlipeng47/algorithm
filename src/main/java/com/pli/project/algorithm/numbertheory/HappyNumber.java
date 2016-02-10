package com.pli.project.algorithm.numbertheory;

import java.util.HashSet;

/**
 * Created by lipeng on 2016/1/22.
 * http://www.lintcode.com/en/problem/happy-number/
 */
public class HappyNumber {

    public static boolean isHappy(int n) {
        // Write your code here
        HashSet<Integer> hs = new HashSet<Integer>();
        while (!hs.contains(n)) {
            hs.add(n);
            int next = 0;
            while (n != 0) {
                int unit = n - n / 10 * 10;
                n /= 10;
                next += Math.pow(unit, 2);
            }
            if (next == 1) {
                return true;
            }
            n = next;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
