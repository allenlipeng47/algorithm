package com.pli.project.algorithm.leetcode;

import java.util.Random;

/**
 * Created by lipeng on 2016/8/30.
 * https://leetcode.com/problems/shuffle-an-array/
 * Loop i from 0 to n - 1. For element i, swap i with any element in [0,...,i]
 */
public class l384Shuffling {

    int[] nums;
    Random random;

    public l384Shuffling(int[] nums) {
        random = new Random();
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] ans = nums.clone();
        for (int i = 0; i < ans.length; i++) {
            int j = random.nextInt(i + 1);
            swap(ans, i, j);
        }
        return ans;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
