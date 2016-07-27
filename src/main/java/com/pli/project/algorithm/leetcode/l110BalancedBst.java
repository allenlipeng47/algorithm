package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/7/26.
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class l110BalancedBst {

    public boolean isBalanced(TreeNode root) {
        return helper(root) >= 0 ? true : false;
    }

    // if it is balanced, return height. Or return -1
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = helper(root.left);
        if (leftHeight < 0) {
            return -1;
        }
        int rightHeight = helper(root.right);
        if (rightHeight < 0) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) <= 1) {
            return Math.max(leftHeight, rightHeight) + 1;
        }
        return -1;
    }
}
