package com.pli.project.algorithm.leetcode;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/8/31.
 * https://leetcode.com/problems/3sum-closest/
 */
public class l163SumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                ans = Math.abs(sum - target) < Math.abs(ans - target) ? sum : ans;
                if (sum < target) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1, 1, 1, 0}, 100));
        System.out.println(threeSumClosest(new int[]{1, 1, -1, -1, 3}, -1));
    }

}
