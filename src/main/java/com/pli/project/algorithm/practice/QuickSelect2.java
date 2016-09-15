package com.pli.project.algorithm.practice;

/**
 * Created by lipeng on 2016/9/14.
 */
public class QuickSelect2 {

    public static void main(String[] args) {
        int[] nums = {2, 1};
        System.out.println(quickSelect(nums, 1));
    }
    public static int quickSelect(int[] nums, int k) {
        k = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int lo = left, hi = right, pivot = nums[left];
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
            if (lo == k) {
                return nums[lo];
            }
            else if (lo < k) {
                left = lo + 1;
            }
            else {
                right = lo - 1;
            }
        }
        return Integer.MIN_VALUE;
    }

}
