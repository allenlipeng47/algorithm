package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/3/25.
 */
public class MinSizeSumArray {

    public int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = 0, ans = Integer.MAX_VALUE, sum = 0;
        while (j <= nums.length) {
            if (sum >= s) {
                ans = Math.min(ans, j - i);
                sum -= nums[i++];
            }
            else if (j < nums.length){
                sum += nums[j++];
            }
            else {
                j++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
