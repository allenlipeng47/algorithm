package com.pli.project.algorithm.numbertheory;

/**
 * Created by lipeng on 2016/2/22.
 * https://leetcode.com/problemset/algorithms/
 */
public class SelfCrossing {

    public static boolean isSelfCrossing(int[] x) {
        if (x == null || x.length <= 3) {
            return false;
        }
        for (int i = 3; i < x.length; i++) {
            if (x[i - 1] <= x[i - 3] && x[i] >= x[i - 2]) {
                return true;
            }
            else if (i >= 4 && x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) {
                return true;
            }
            else if (i >= 5 && x[i - 1] <= x[i - 3] && x[i - 2] >= x[i - 4]
                    && x[i] + x[i - 4] >= x[i - 2] && x[i - 5] + x[i - 1] >= x[i - 3]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] arr = {1,1,2,1,1};
//        int[] arr = {1,2,2,2};
//        int[] arr = {1,1,3,2,1,1};
//        int[] arr = {1,1,3,2,1,1};
//        int[] arr = {3, 3, 4, 2, 2};
//        int[] arr = {1,1,2,2,3,3,4,4,10,4,4,3,3,2,2,1,1};
        int[] arr = {1,1,2,2,5,2,2,1,1};
        System.out.println(isSelfCrossing(arr));
    }

}
