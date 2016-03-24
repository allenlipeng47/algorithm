package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/3/23.
 */
public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<Integer>(), k, n, 0);
        return ans;
    }

    public void helper(List<List<Integer>> ans, List<Integer> curr, int k, int n, int max) {
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(curr));
        }
        else if (k <= 0 || n <= 0) {
            return;
        }
        for (int i = max + 1; i <= 9; i++) {
            if (i <= n && k > 0) {
                curr.add(i);
                helper(ans, curr, k - 1, n - i, i);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        CombinationSumIII c = new CombinationSumIII();
        ans = c.combinationSum3(3, 7);
        System.out.println(ans);
    }


}
