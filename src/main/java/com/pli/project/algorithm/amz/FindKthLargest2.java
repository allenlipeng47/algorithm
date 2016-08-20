package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/20.
 */
public class FindKthLargest2 {

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
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
            if (k == lo) {
                return pivot;
            }
            else if (k < lo) {
                right = lo - 1;
            }
            else {
                left = lo + 1;
            }
        }
        return -1;
    }

}
