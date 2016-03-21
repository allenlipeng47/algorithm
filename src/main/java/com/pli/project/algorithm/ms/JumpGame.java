package com.pli.project.algorithm.ms;

/**
 * Created by lipeng on 2016/3/19.
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int max = 0;
        for (int i = 0; i < nums.length && max >= i; i++) {
            max = Math.max(max, i + nums[i]);
        }
        return max >= nums.length - 1;
    }

    public static void main(String[] args) {
        JumpGame j = new JumpGame();
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(j.canJump(nums));
    }


}
