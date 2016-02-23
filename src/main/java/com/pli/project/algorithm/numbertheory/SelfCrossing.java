package com.pli.project.algorithm.numbertheory;

/**
 * Created by lipeng on 2016/2/22.
 * https://leetcode.com/problemset/algorithms/
 */
public class SelfCrossing {

    public static boolean isSelfCrossing(int[] x) {
        if (x == null || x.length < 4) {
            return false;
        }
        if (x[3] >= x[1] && x[2] <= x[0]) {
            return true;
        }
        for (int i = 4; i < x.length; i++) {
            if (x[i - 1] <= x[i - 3]) {
                if (x[i - 2] <= x[i - 4]) {
                    if (x[i] >= x[i - 2]) {
                        return true;
                    }
                }
                else {
                    if (x[i] + x[i - 4] >= x[i - 2]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] arr = {1,1,2,1,1};
//        int[] arr = {1,2,2,2};
        int[] arr = {1,2,2,3, 4};
        System.out.println(isSelfCrossing(arr));
    }

}
