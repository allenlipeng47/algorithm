package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2016/1/10.
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        int[] rec = new int[nums.length + 1];   //rec[i] = k;   the longest lenght of i ends at k;
        rec[0] = Integer.MIN_VALUE;
        int top = 0;
        for(int i = 0; i < nums.length; i++) {
            int j = top + 1;
            while (nums[i] <= rec[j - 1])
                j--;
            if(j == top + 1) {
                rec[j] = nums[i];
                top++;
            }
            else if(nums[i] < rec[j]) {
                rec[j] = nums[i];
            }
        }
        return top;
    }

    public static void main(String[] args) {
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {2, 2};
        System.out.println(lengthOfLIS(nums));
    }

}
