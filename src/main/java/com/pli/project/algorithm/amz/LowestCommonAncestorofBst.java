package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.util.TreeNode;

/**
 * Created by lipeng on 2016/8/10.
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LowestCommonAncestorofBst {

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        if (root.val >= min && root.val <= max) {
            return root;
        }
        if (root.val <= min) {
            return lowestCommonAncestor2(root.right, p, q);
        }
        else {
            return lowestCommonAncestor2(root.left, p, q);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }


}
