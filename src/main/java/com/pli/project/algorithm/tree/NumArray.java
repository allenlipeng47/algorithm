package com.pli.project.algorithm.tree;

/**
 * Created by lipeng on 2016/1/11.
 * https://leetcode.com/problems/range-sum-query-mutable/
 */
public class NumArray {

    int[] tree;
    int[] nums;
    int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        tree = new int[n + 1];
        for(int i = 0; i < n; i++)
            increase(i, nums[i]);
    }

    public void update(int idx, int val) {
        int diff = val - nums[idx];
        nums[idx] = val;
        increase(idx, diff);
    }

    // increase val on nums[idx]
    private void increase(int idx, int val) {
        idx++;
        while (idx <= n) {
            tree[idx] += val;
            idx += (-idx) & idx;
        }
    }

    private int getSum(int idx) {
        idx++;  // idx in tree is greater position in array than 1.
        int sum = 0;
        while (idx > 0) {
            sum += tree[idx];
            idx -= (-idx) & idx;
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        NumArray tree = new NumArray(nums);
//        tree.update(2, 0);
        System.out.println(tree.sumRange(1, 2));
    }

}
