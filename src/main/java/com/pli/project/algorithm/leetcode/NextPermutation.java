package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/9/8.
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int smallPos = nums.length - 2;
        while (smallPos >= 0 && nums[smallPos] >= nums[smallPos + 1]) {
            smallPos--;
        }
        int bigPos = nums.length - 1;
        while (bigPos > smallPos && nums[bigPos] <= nums[smallPos]) {
            bigPos--;
        }
        for (bigPos = nums.length - 1; bigPos < smallPos; bigPos--) {
            if (nums[bigPos] > nums[smallPos]) {
                break;
            }
        }

    }

}
