package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/8/29.
 * https://leetcode.com/problems/wiggle-subsequence/
 */
public class l376WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int asc = 1, desc = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {    // update increasing by decreasing
                asc = desc + 1;
            }
            else if (nums[i] < nums[i - 1]) {   // update decreasing by increasing
                desc = asc + 1;
            }
        }
        return Math.max(asc, desc);
    }

    public int wiggleMaxLength2(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int i = 1;
        while (i < nums.length && nums[i] == nums[i - 1]) {
            i++;
        }
        if (i == nums.length) {
            return 1;
        }
        boolean increasing = nums[i] > nums[i - 1];
        int ans = 2;
        for (i = i + 1; i < nums.length; i++) {
            if (increasing && nums[i] < nums[i - 1]) {
                ans++;
                increasing = !increasing;
            }
            else if (!increasing && nums[i] > nums[i - 1]) {
                ans++;
                increasing = !increasing;
            }
        }
        return ans;
    }

}
