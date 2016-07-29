package com.pli.project.algorithm.tree;

import com.pli.project.algorithm.util.TreeNode;

/**
 * Created by lipeng on 2016/7/28.
 * If current node has left child, then print current node.
 * If current node doesn't has left child,  then we check the right most of left child.
 *      If right most of left child is null, then point its right child to curr.
 *      If right most of left child is not null, it means left child is already traversed. We need to set right most right child to null.
 */
public class MorrisTraversal {

    public static void morrisTraversal(TreeNode node) {
        TreeNode curr = node;
        while (curr != null) {
            if (curr.left == null) {    // if left is null, then print
                System.out.println(curr.val);
                curr = curr.right;
                continue;
            }
            TreeNode pre = curr.left;
            while (pre.right != null && pre.right != curr) {
                pre = pre.right;
            }
            if (pre.right == null) {
                pre.right = curr;
                curr = curr.left;
            }
            else {  // right end already points to curr, it means left is already traversed.
                pre.right = null;
                System.out.println(curr.val);
                curr = curr.right;
            }
        }   // while
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        t4.left = t2; t4.right = t6;
        t2.left = t1; t2.right = t3;
        t6.left = t5; t6.right = t7;
        morrisTraversal(t4);
    }

}
