package com.pli.project.algorithm.ms;

/**
 * Created by lipeng on 2016/3/20.
 */
public class FindKthLargest {

    public static int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int lo = left, hi = right, pivot = nums[left];
            // partition nums[left,...,right] by pivot nums[left]
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
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 3, 2};
        System.out.println(findKthLargest(nums, 3));
    }

}
