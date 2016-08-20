package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/20.
 */
public class QuickSort {

    public void quickSort(int[] nums) {
        partition(nums, 0, nums.length - 1);
    }

    private void partition(int[] nums, int left, int right) {
        int lo = left, hi = right;
        if (lo >= hi) {
            return;
        }
        int pivot = nums[lo];
        while (lo < hi) {
            while (lo < hi && pivot <= nums[hi]) {
                hi--;
            }
            nums[lo] = nums[hi];
            while (lo < hi && pivot >= nums[lo]) {
                lo++;
            }
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        partition(nums, left, lo - 1);
        partition(nums, lo + 1, right);
    }

}
