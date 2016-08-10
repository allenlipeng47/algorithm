package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.util.TreeNode;

/**
 * Created by lipeng on 2016/8/9.
 */
public class Lca {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }


}
