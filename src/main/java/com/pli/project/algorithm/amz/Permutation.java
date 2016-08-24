package com.pli.project.algorithm.amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lipeng on 2016/8/23.
 * https://leetcode.com/problems/permutations/
 */
public class Permutation {

    public List<List<Integer>> combinate(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (int i : nums) {
            List<List<Integer>> tmp = new ArrayList<>(list);
            for (List<Integer> l : tmp) {
                List<Integer> curr = new ArrayList<>(l);
                curr.add(i);
                list.add(curr);
            }
        }
        return list;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, ans, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }

    private void helper(int[] nums, List<List<Integer>> ans, List<Integer> curr, boolean[] used) {
        if (curr.size() == used.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                curr.add(nums[i]);
                helper(nums, ans, curr, used);
                curr.remove(curr.size() - 1);
                used[i] = false;
            }
        }
    }

}
