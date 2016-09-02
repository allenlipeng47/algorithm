package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/9/1.
 * https://leetcode.com/problems/remove-element/
 */
public class l27RemoveElements {

    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

}
