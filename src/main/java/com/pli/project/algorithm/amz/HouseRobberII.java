package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/20.
 */
public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums == nums || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

    private int helper(int[] nums, int i, int j) {
        int rob = 0, noRob = 0;
        for (int k = 1; k <= j; k++) {
            int r = rob, n = noRob;
            rob = nums[k] + n;
            noRob = Math.max(r, n);
        }
        return Math.max(rob, noRob);
    }

}
