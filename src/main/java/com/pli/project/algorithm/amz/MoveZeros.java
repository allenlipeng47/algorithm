package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/16.
 */
public class MoveZeros {

    public static void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left++, right);
            }
            right++;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
