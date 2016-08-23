package com.pli.project.algorithm.amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lipeng on 2016/8/22.
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(ans, new ArrayList<>(), candidates, target, 0, new boolean[candidates.length]);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> currAns, int[] candidates, int target, int pos, boolean[] used) {
        if (target == 0) {
            ans.add(new ArrayList<>(currAns));
            return;
        }
        if (target < 0 || pos >= candidates.length) {
            return;
        }
        helper(ans, currAns, candidates, target, pos + 1, used);
        if (pos > 0 && candidates[pos] == candidates[pos - 1] && !used[pos - 1]) {
            return;
        }
        currAns.add(candidates[pos]);
        used[pos] = true;
        helper(ans, currAns, candidates, target - candidates[pos], pos + 1, used);
        currAns.remove(currAns.size() - 1);
        used[pos] = false;
    }
}
