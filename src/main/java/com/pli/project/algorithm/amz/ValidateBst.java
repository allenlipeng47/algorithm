package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.util.TreeNode;

/**
 * Created by lipeng on 2016/8/12.
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBst {

    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return helper(root.left, min , root.val) && helper(root.right, root.val, max);
    }


}
