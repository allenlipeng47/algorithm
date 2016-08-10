package com.pli.project.algorithm.practice;

/**
 * Created by lipeng on 2016/8/10.
 */
public class SerachInRotatedArray {


    public static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
                continue;
            }
            if (nums[left]  <= nums[mid]) { // left side is longer
                if (nums[left] <= target && target < nums[mid]) {   // to left side
                    right = mid - 1;
                }
                else {  // to right side
                    left = mid + 1;
                }
            }
            else {
                if (nums[mid] < target && target <= nums[right]) {  // to right side
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(search(nums, 1));
    }

}
