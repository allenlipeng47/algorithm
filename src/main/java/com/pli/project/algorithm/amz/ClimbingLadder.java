package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/21.
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingLadder {

    public int climbStairs(int n) {
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 3; i <= n; i++) {
            arr[(i + 2) % 3] = arr[(i + 1) % 3] + arr[(i) % 3];
        }
        return arr[(n + 2) % 3];
    }

}
