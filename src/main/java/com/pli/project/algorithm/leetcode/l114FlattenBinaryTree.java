package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/7/25.
 * Create a helper function. It will flatten the root and return the tail.
 */
public class l114FlattenBinaryTree {

    public static void flatten(TreeNode root) {
        helper(root);
    }

    public static TreeNode helper(TreeNode root) {
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
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2; t1.right = t5;
        t2.left = t3; t2.right = t4;
        t5.left = t6; t5.right = t7;
        flatten(t1);
        System.out.println();
    }
}




