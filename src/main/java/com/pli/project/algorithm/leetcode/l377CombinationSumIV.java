package com.pli.project.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lipeng on 2016/8/31.
 * https://leetcode.com/problems/combination-sum-iv/
 */
public class l377CombinationSumIV {

    public static int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        return helper(nums, target, hm);
    }

    private static int helper(int[] nums, int target, Map<Integer, Integer> hm) {
        if (target < 0) {
            return 0;
        }
        if (hm.containsKey(target)) {
            return hm.get(target);
        }
        int ans = 0;
        for (int i : nums) {
            ans += helper(nums, target - i, hm);
        }
        hm.put(target, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
    }

}
