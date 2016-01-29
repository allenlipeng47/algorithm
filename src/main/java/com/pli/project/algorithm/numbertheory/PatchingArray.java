package com.pli.project.algorithm.numbertheory;

/**
 * Created by pli on 1/28/2016.
 */
public class PatchingArray {




    public static int minPatches(int[] nums, int n) {
        int i = 0, count = 0;
        long reach = 0;
        while (reach < n) {
            if (i < nums.length && reach + 1 >= nums[i]) {
                reach += nums[i++];
            }
            else {
                reach = reach * 2 + 1;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3}; int n = 6;
//        int[] nums = {1, 5, 10}; int n = 20;
//        int[] nums = {1, 2, 2}; int n = 5;
//        int[] nums = {1, 2, 4, 13, 43}; int n = 100;
        System.out.println(minPatches(nums, n));

    }
}
