package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/4/21.
 * https://leetcode.com/problems/find-peak-element/
 */
public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid - 1]) {
                right = mid - 1;
            }
            else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
            else {
                return nums[mid];
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        System.out.println(findPeakElement(nums));
    }

}
