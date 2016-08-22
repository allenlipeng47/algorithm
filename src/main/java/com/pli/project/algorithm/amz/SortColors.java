package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/21.
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int pos0 = 0, pos1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, pos1++, i);
            }
            else if (nums[i] == 0) {
                swap(nums, pos1, i);
                swap(nums, pos0++, pos1++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
