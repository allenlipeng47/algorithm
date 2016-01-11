package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2016/1/10.
 * https://leetcode.com/problems/range-sum-query-mutable/
 * Basic idea is that sum[i, j] = sum[0, j] - sum[0, i - 1]
 */
public class NumArray {

    int[] sum;
    int[] nums;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        this.nums = nums;
        for(int i = 1; i < sum.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];
    }

    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        for (; i < nums.length; i++)
            sum[i + 1] += diff;
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray array = new NumArray(nums);
        array.update(1, 2);
        System.out.println(array.sumRange(1, 2));
    }
}
