package com.pli.project.algorithm.ms;

import com.pli.project.algorithm.util.TreeNode;

/**
 * Created by lipeng on 2016/3/17.
 */
public class Lcs {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return null;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        else if (left != null) {
            return left;
        }
        else {
            return right;
        }
    }
}
