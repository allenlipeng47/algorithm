package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by lipeng on 2016/8/4.
 * https://leetcode.com/problems/subsets-ii/
 * This is a very good one! It is much better than recursive version.
 * let's say we want to get subset for [1, 2, 3, 3]. Assume we have subset(1, 2) = {[], [1], [2], [1, 2]}.
 * Based on subset(1, 2), we can either add zero 3, add one 3, or two 3 in the subset(1, 2)
 */
public class l90SubSetII {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(Collections.singleton(new ArrayList<>()));
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            int next = i + 1;
            while (next < nums.length && nums[next] == nums[i]) {
                next++;
            }
            int size = ans.size();
            for (int j = 0; j < size; j++) {
                List<Integer> curr = new ArrayList<>(ans.get(j));
                for (int k = 1; k <= next - i; k++) {
                    curr.add(nums[i]);
                    ans.add(new ArrayList<>(curr));
                }
            }
            i = next;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> list = subsetsWithDup(nums);
        System.out.println(list);
    }

}
