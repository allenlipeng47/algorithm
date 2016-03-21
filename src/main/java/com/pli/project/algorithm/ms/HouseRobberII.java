package com.pli.project.algorithm.ms;

/**
 * Created by lipeng on 2016/3/17.
 */
public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        else if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    public int robHelper(int[] nums, int i, int j) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int noRob = 0, rob = nums[i];
        for (int k = i + 1; k <= j; k++) {
            int newRob = noRob + nums[k];
            noRob = Math.max(noRob, rob);
            rob = newRob;
        }
        return Math.max(rob, noRob);
    }

    public static void main(String[] args) {
        HouseRobberII h = new HouseRobberII();
//        int[] nums = {1, 1, 1};
        int[] nums = {1, 2};
        System.out.println(h.rob(nums));
    }
}
