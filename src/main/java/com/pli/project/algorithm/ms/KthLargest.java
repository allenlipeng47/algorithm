package com.pli.project.algorithm.ms;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/3/17.
 */
public class KthLargest {

    public static int findKthLargest(int[] nums, int k) {
        return findKthLargestHelper(nums, nums.length - k, 0, nums.length - 1);
    }

    public static int findKthLargestHelper(int[] nums, int k, int left, int right) {
        int pivot = nums[left];
        int lo = left, hi = right;
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
        if (lo == k) {
            return pivot;
        }
        else if (lo < k) {
            return findKthLargestHelper(nums, k, lo + 1, right);
        }
        else {
            return findKthLargestHelper(nums, k, left, lo - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {99, 99};
//        int[] nums = {-1, 2, 0};
        System.out.println(findKthLargest(nums, 1));
//        quickSort(nums);
//        System.out.println(Arrays.toString(nums));

    }
}
