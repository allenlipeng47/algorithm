package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/8/9.
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Similar to lc81.
 */
public class l31SearchInRotatedArray {

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] >= nums[left]) {    // left side is longer
                if (nums[left] <= target && target < nums[mid]) {   // to left side
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else {  // right side is longer
                if (nums[mid] < target && target <= nums[right]) {  // to right side
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1};
        System.out.println(search(nums, 1));
    }

}
