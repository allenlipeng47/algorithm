package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/7/27.
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class l104MaxDeptBst {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


}
