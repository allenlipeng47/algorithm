package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/8/7.
 * https://discuss.leetcode.com/topic/16660/my-8ms-c-solution-o-logn-on-average-o-n-worst-case
 1) everytime check if targe == nums[mid], if so, we find it.
 2) otherwise, we check if the first half is in order (i.e. nums[left]<=nums[mid])
 and if so, go to step 3), otherwise, the second half is in order,   go to step 4)
 3) check if target in the range of [left, mid-1] (i.e. nums[left]<=target < nums[mid]), if so, do search in the first half, i.e. right = mid-1; otherwise, search in the second half left = mid+1;
 4)  check if target in the range of [mid+1, right] (i.e. nums[mid]<target <= nums[right]), if so, do search in the second half, i.e. left = mid+1; otherwise search in the first half right = mid-1;
 */
public class l81SearchInRotatedArrayII {

    public static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return true;
            }
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
            else if (nums[mid] >= nums[left]) { // left side is longer
                if (target >= nums[left] && target < nums[mid]) {   // to left
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else {  // right side is longer
                if (nums[mid] < target && target <= nums[right]) {  // to right
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
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 2));
    }

}
