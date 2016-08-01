package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/7/29.
 * https://leetcode.com/problems/recover-binary-search-tree/
 * Template for Morris Traversal is here http://www.allenlipeng47.com/blog/index.php/2016/07/29/morris-traversal/.
 */
public class l99RecoverBst {

    public static void recoverTree(TreeNode root) {
        TreeNode pre = null, curr = root, first = null, second = null;
        while (curr != null) {
            if (curr.left == null) {    // pop point and compare
                if (pre != null && curr.val < pre.val) {
                    if (first == null) {
                        first = pre;
                    }
                    second = curr;
                }
                pre = curr;
                curr = curr.right;
                continue;
            }
            TreeNode rightMost = curr.left;
            while (rightMost.right != null && rightMost.right != curr) {
                rightMost = rightMost.right;
            }
            if (rightMost.right == null) {
                rightMost.right = curr;
                curr = curr.left;
            }
            else {
                if (pre != null && curr.val < pre.val) {
                    if (first == null) {
                        first = pre;
                    }
                    second = curr;
                }
                pre = curr;
                curr = curr.right;
                rightMost.right = null;
            }
        }
        int val = first.val;
        first.val = second.val;
        second.val = val;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(2);
        TreeNode t7 = new TreeNode(7);
        t4.left = t2; t4.right = t6;
        t2.left = t1; t2.right =t3;
        t6.left = t5; t6.right = t7;
        recoverTree(t4);
        System.out.println();
    }

}
