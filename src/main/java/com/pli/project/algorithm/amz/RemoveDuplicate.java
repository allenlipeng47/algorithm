package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/21.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicate {

    public int removeDuplicates2(int[] nums) {
        int left = 0, right = 1;
        while (right < nums.length) {
            while (right < nums.length && nums[left] == nums[right]) {
                right++;
            }
            if (right >= nums.length) {
                break;
            }
            left++;
            nums[left] = nums[right];
            right++;
        }
        return left + 1;
    }

    public int removeDuplicates(int[] nums) {
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
        }
        return left + 1;
    }

}
