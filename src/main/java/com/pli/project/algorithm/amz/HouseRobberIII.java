package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.util.TreeNode;

/**
 * Created by lipeng on 2016/8/20.
 */
public class HouseRobberIII {

    public int rob(TreeNode root) {
        int[] ans = helper(root);
        return Math.max(ans[0], ans[1]);
    }

    /* ans[] = {rob, noRob}
    rob = leftNoRob + rightNoRob + root.value;
    noRob = max(leftRob, leftNoRob) + max(rightRob, rightNoRob)
    */
    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        int[] ans = new int[2];
        ans[0] = node.val + left[1] + right[1];
        ans[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return ans;
    }
}
