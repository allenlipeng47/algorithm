package com.pli.project.algorithm.ms;

import com.pli.project.algorithm.util.TreeNode;

/**
 * Created by lipeng on 2016/3/17.
 * http://www.cnblogs.com/jcliBlogger/p/4763200.html
 Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 Note:
 Given target value is a floating point.
 You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
public class ClosestBst {

    private int ans;
    private double diff = Double.MAX_VALUE;

    public int findClosetNode(TreeNode tree, double target) {
        if (tree == null) {
            return ans;
        }
        double currDiff = Math.abs(target - tree.val);
        if (currDiff < diff) {
            ans = tree.val;
            diff = currDiff;
        }
        if (target < tree.val) {
            findClosetNode(tree.left, target);
        }
        else if (target > tree.val) {
            findClosetNode(tree.right, target);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        t5.left = t2; t5.right = t8;
        t2.left = t1; t2.right = t4;
        t4.left = t3;
        t8.left = t6; t8.right = t9;
        t6.right = t7;
        t1.left = t0;
        ClosestBst bst = new ClosestBst();
        System.out.println(bst.findClosetNode(t5, 2.9));
    }



}
