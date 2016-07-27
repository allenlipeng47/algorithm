package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/7/26.
 * https://leetcode.com/problems/path-sum-ii/
 * When traverse, use the skill sum = sum - root.val, until sum == 0
 */
public class l113SumPathII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, sum, ans, new ArrayList<>());
        return ans;
    }

    private void helper(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> currAns) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        currAns.add(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            ans.add(new ArrayList<>(currAns));
        }
        else {
            helper(root.left, sum, ans, currAns);
            helper(root.right, sum, ans, currAns);
        }
        currAns.remove(currAns.size() - 1);
    }


}
