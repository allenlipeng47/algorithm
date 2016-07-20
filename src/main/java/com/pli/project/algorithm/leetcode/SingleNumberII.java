package com.pli.project.algorithm.leetcode;

/**
 * https://leetcode.com/problems/single-number-ii/
 * Added the solution. For each bit in the nums, count the sum of 1. If sum % 3 == 0, it means this bit is 0, or this bit should be 1
 */
public class SingleNumberII {

    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0, bit = 1 << i, base = 1 << i;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & bit) != 0) {
                    sum++;
                }
            }
            if (sum % 3 != 0) {
                ans = ans | base;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 0, 1, 0, 1, 0};
        System.out.println(singleNumber(A));
    }

}
