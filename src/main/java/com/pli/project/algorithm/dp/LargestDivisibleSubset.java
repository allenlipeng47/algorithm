package com.pli.project.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lipeng on 2016/7/4.
 * https://leetcode.com/problems/largest-divisible-subset/
 */
public class LargestDivisibleSubset {

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length <= 0) {
            return new ArrayList<Integer>();
        }
        int[] parent = new int[nums.length], count = new int[nums.length];
        Arrays.sort(nums);
        int maxPos = 0; // where the max number in the result subset
        for (int right = 0; right < nums.length; right++) {
            parent[right] = -1;
            count[right] = 1;
            for (int left = 0; left < right; left++) {
                if (nums[right] % nums[left] == 0 && count[left] + 1 > count[right]) {
                    parent[right] = left;
                    count[right] = count[left] + 1;
                    if (count[right] > count[maxPos]) { // update max pos
                        maxPos = right;
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (maxPos != -1) {
            ans.add(nums[maxPos]);
            maxPos = parent[maxPos];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(largestDivisibleSubset(nums));
    }


}
