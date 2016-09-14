package com.pli.project.algorithm.practice;

/**
 * Created by lipeng on 2016/9/14.
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinSubSum {

    public static int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0, ans = Integer.MAX_VALUE, sum = 0;
        while (right <= nums.length) {
            if (sum >= s) {
                ans = Math.min(ans, right - left);
                sum -= nums[left++];
            }
            else if (right < nums.length){
                sum += nums[right++];
            }
            else {
                break;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 4};
        System.out.println(minSubArrayLen(4, nums));
    }

}
