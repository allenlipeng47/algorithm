package com.pli.project.algorithm.sort;

import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by lipeng on 2016/1/2.
 * https://leetcode.com/problems/wiggle-sort-ii/
 */
public class WiggleSortII {

    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, mid = n / 2;
        for(int i = 0, j = n - 1; i < j; i++, j--)
            swap(nums, i, j);
        int[] small = new int[(n + 1) / 2], large = new int[n / 2];
        for(int i = 0; i < mid; i++) {
            large[i] = nums[i];
            small[i] = nums[i + mid];
        }
        if((n & 1) == 1)
            small[mid] = nums[n - 1];
        for(int k = 0, i = 0, j = 0; k < n; k++)
            nums[k] = ((k & 1) == 0) ? small[i++] : large[j++];
    }

    private static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
//        int[] nums = {1, 5, 1, 1, 6, 4, 3};
//        int[] nums = {1, 3, 2, 2, 3, 1};
//        int[] nums = {1,2,2,1,2,1,1,1,1,2,2,2};
//        int[] nums = {1};
//        int[] nums = {3,2,3,3,2,1,1,2,3,1,1,3,2,1,2,2,2,2,1};
        int[] nums = {4, 5, 5, 6};
//        int[] nums = {5, 5, 6, 7, 8};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
