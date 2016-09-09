package com.pli.project.algorithm.leetcode;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/9/8.
 * https://leetcode.com/problems/next-permutation/
 */
public class l31NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2, j = nums.length - 1;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            while (i < j && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        i++;
        j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        l31NextPermutation l = new l31NextPermutation();
        int[] nums = {9, 8, 7, 6, 5, 4, 3};
        l.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}
