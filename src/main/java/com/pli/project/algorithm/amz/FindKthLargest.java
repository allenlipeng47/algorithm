package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/12.
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
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
            if (lo == nums.length - k) {
                return nums[lo];
            }
            else if (lo < nums.length - k) {
                left = lo + 1;
            }
            else {
                right = lo - 1;
            }
        }
        return -1;
    }

}
