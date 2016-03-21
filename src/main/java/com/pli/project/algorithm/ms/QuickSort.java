package com.pli.project.algorithm.ms;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/3/20.
 */
public class QuickSort {

    public static void quickSort(int[] nums) {
        partition(nums, 0, nums.length - 1);
    }

    private static void partition(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = nums[left], lo = left, hi = right;
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

    public static void main(String[] args) {
        int[] nums = {5,3,6,7,9,2,1};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
