package com.pli.project.algorithm.amz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/8/22.
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void helper(int[] candidates, int target, List<List<Integer>> ans, List<Integer> currAns, int pos) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(currAns));
        }
        for (int i = pos; i < candidates.length; i++) {
            currAns.add(candidates[i]);
            helper(candidates, target - candidates[i], ans, currAns, i);
            currAns.remove(currAns.size() - 1);
        }
    }

}
