package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/21.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDupFromSlII {

    // left is the position where we are going to put next element.
    // right is current element
    public int removeDuplicates2(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                nums[left] = nums[left + 1] = nums[right];
                right += 2;
                while (right < nums.length && nums[left] == nums[right]) {
                    right++;
                }
                left += 2;
            }
            else {
                nums[left++] = nums[right++];
            }
        }
        return left;
    }

    public int removeDuplicates(int[] nums) {
        int curr = 0;
        for (int i : nums) {
            if (curr < 2 || i != nums[curr - 2]) {
                nums[curr++] = i;
            }
        }
        return curr;
    }

}
