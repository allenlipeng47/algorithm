package com.pli.project.algorithm.array;

import java.math.BigInteger;

/**
 * Created by lipeng on 2016/6/29.
 * https://leetcode.com/problems/water-and-jug-problem/
 */
public class WaterJug {

    public static int gcd(int x, int y) {
        int diff = Math.abs(x - y);
        if (diff == 0) {
            return x;
        }
        else {
            return gcd(diff, Math.min(x, y));
        }
    }

    public static boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == z || y == z) {
            return true;
        }
        return gcd(x, y) == 0;
    }
    public static void main(String[] args) {
        System.out.println(canMeasureWater(0, 2, 1));
    }

}
