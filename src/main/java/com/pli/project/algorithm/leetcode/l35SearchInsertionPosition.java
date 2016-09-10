package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/9/10.
 * https://leetcode.com/problems/search-insert-position/
 * A good practice for binary search.
 */
public class l35SearchInsertionPosition {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 4, 4, 4, 5};
        System.out.println(searchInsert(nums, 5));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums[0] >= target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) { // must has an answer
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                if (nums[mid - 1] < target) {
                    return mid;
                }
                else {
                    right = mid - 1;
                }
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

}
