package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.leetcode.TreeNode;

/**
 * Created by lipeng on 2016/8/23.
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetryTree {

    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    private boolean helper(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && helper(t1.left, t2.right) && helper(t1.right, t2.left);
    }

}
