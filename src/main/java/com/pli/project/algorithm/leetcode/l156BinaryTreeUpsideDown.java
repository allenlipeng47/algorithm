package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/9/8.
 * http://www.cnblogs.com/grandyang/p/5172838.html
 */
public class l156BinaryTreeUpsideDown {

    static TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode pre = null, preRight = null;
        while (root != null) {
            TreeNode left = root.left, right = root.right;
            root.left = preRight;
            root.right = pre;
            pre = root;
            preRight = right;
            root = left;
        }
        return pre;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5;
        t4.left = t6;
        TreeNode ans = upsideDownBinaryTree(t1);
        System.out.println();
    }

}
