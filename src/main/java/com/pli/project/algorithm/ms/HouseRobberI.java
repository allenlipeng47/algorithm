package com.pli.project.algorithm.ms;

/**
 * Created by lipeng on 2016/3/17.
 */
public class HouseRobberI {

    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int noRob = 0, rob = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int newRob = nums[i] + noRob;
            noRob = Math.max(noRob, rob);
            rob = newRob;
        }
        return Math.max(rob, noRob);
    }

}
