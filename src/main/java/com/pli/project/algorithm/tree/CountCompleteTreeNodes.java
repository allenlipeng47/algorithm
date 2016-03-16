package com.pli.project.algorithm.tree;

import com.pli.project.algorithm.util.TreeNode;

/**
 * Created by lipeng on 2015/12/12.
 * https://leetcode.com/problems/count-complete-tree-nodes/
 * For each node, test left height and right height. If left and right height are the same, total nodes is 2^(height + 1) - 1.
 * If not, dfs left and right node.
 */
public class CountCompleteTreeNodes {

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lHeight = getLeftHeight(root.left);
        int rHeight = getRightHeight(root.right);
        if (lHeight == rHeight) {
            return (1 << (lHeight + 1)) - 1;
        }
        else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    public static int getLeftHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }

    public static int getRightHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.right;
        }
        return height;
    }




    public static void main(String[] args) {
//        TreeNode t1 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(2);
//        TreeNode t3 = new TreeNode(3);
//        TreeNode t4 = new TreeNode(4);
//        TreeNode t5 = new TreeNode(5);
//        TreeNode t6 = new TreeNode(6);
//        TreeNode t7 = new TreeNode(7);
//        TreeNode t8 = new TreeNode(8);
//        TreeNode t9 = new TreeNode(9);
//        TreeNode t10 = new TreeNode(10);
//        t1.left = t2; t1.right = t3;
//        t2.left = t4; t2.right = t5;
//        t3.left = t6; t3.right = t7;
//        t4.left = t8; t4.right = t9;
//        t5.left = t10;
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5;
        t3.left = t6; t3.right = t7;
        System.out.println(countNodes(t1));
    }

}