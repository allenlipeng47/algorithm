package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/7/6.
 */
public class MaxProductSubarray {

    public static int maxProduct(int[] nums) {
        int localMax, localMin, globalMax, globalMin;
        localMax = localMin = globalMax = globalMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int localMaxTmp = Math.max(Math.max(localMax * nums[i], localMin * nums[i]), nums[i]);
            int localMinTmp = Math.min(Math.min(localMax * nums[i], localMin * nums[i]), nums[i]);
            localMax = localMaxTmp;
            localMin = localMinTmp;
            globalMax = Math.max(localMax, globalMax);
            globalMin = Math.min(localMin, globalMin);
        }
        return globalMax;
    }

    public static int maxProductNaiveWay(int[] nums) {
        int[] localMax = new int[nums.length];
        int[] globalMax = new int[nums.length];
        int[] localMin = new int[nums.length];
        int[] globalMin = new int[nums.length];
        localMax[0] = globalMax[0] = localMin[0] = globalMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            localMax[i] = Math.max(Math.max(localMax[i - 1] * nums[i], localMin[i - 1] * nums[i]), nums[i]);
            localMin[i] = Math.min(Math.min(localMax[i - 1] * nums[i], localMin[i - 1] * nums[i]), nums[i]);
            globalMax[i] = Math.max(localMax[i], globalMax[i - 1]);
            globalMin[i] = Math.min(localMin[i], globalMin[i - 1]);
        }
        return globalMax[nums.length - 1];
    }

    public static void main(String[] args) {
//        int[] nums = {2, 3, -2, 4};
        int[] nums = {-2, 3, -4};
        System.out.println(maxProduct(nums));
    }

}
