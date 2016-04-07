package com.pli.project.algorithm.leetcode;

import java.util.HashSet;

/**
 * Created by lipeng on 2016/4/6.
 */
public class HappyNumber {

    public boolean isHappy2(int n) {
        HashSet<Integer> hs = new HashSet<>();
        while (!hs.contains(n)) {
            hs.add(n);
            int num = 0;
            while (n > 0) {
                num += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (num == 1) {
                return true;
            }
            n = num;
        }
        return false;
    }

    public boolean isHappy(int n) {
        int slow = n, fast = next(n);
        while (slow != fast) {
            slow = next(slow);
            fast = next(fast);
            fast = next(fast);
        }
        if (slow == 1) {
            return true;
        }
        return false;
    }

    private int next(int n) {
        int num = 0;
        while (n > 0) {
            num += Math.pow(n % 10, 2);
            n /= 10;
        }
        return num;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(19));
    }

}
