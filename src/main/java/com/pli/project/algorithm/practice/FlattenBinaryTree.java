package com.pli.project.algorithm.practice;

import com.pli.project.algorithm.leetcode.TreeNode;

/**
 * Created by lipeng on 2016/9/9.
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTree {

    public static void flatten(TreeNode root) {
        helper(root);
    }

    private static TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftTail = helper(root.left);
        TreeNode rightTail = helper(root.right);
        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (rightTail != null) {
            return rightTail;
        }
        if (leftTail != null) {
            return leftTail;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t2.left = t3;
        helper(t1);
        System.out.println();
    }

}
