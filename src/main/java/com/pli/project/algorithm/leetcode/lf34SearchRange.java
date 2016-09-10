package com.pli.project.algorithm.leetcode;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/9/10.
 * https://leetcode.com/problems/search-for-a-range/
 * A good practice for binary search.
 */
public class lf34SearchRange {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(Arrays.toString(searchRange(nums, 1)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int midPos = -1, left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                midPos = mid;
                break;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        if (midPos == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{searchLeft(nums, midPos), searchRight(nums, midPos)};
    }

    // {1, 2, 3, 4, 4, 4, 5, 6}, 4 will return 3. Left bound
    private static int searchLeft(int[] nums, int right) {
        int target = nums[right];
        if (nums[0] == target) {
            return 0;
        }
        int left = 0, hi = right;
        while (left <= right) {  // must has an answer
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (nums[mid - 1] != target) {
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
        return -1;
    }

    // {1, 2, 3, 4, 4, 4, 5, 6}, 4 will return 5. Right bound
    private static int searchRight(int[] nums, int left) {
        int target = nums[left];
        if (nums[nums.length - 1] == target) {
            return nums.length - 1;
        }
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (nums[mid + 1] != target) {
                    return mid;
                }
                else {
                    left = mid + 1;
                }
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }


}
