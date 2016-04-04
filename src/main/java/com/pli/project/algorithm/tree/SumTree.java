package com.pli.project.algorithm.tree;

/**
 * Created by lipeng on 2016/2/3.
 * Sum tree
 * http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
 */
public class SumTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static boolean isSumTree(TreeNode node) {
        if (isSumTreeHelper(node) >= 0) {
            return true;
        }
        return false;
    }

    /**
     * Return val is less than 0, means false. Then keep returning.
     * If is a leaf node, then return node.val.
     * If it is not a leaf node, Sumtree should have node.val = left + right.
     * @param node
     * @return
     */
    public static int isSumTreeHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = isSumTreeHelper(node.left);
        if (left < 0) {
            return -1;
        }
        int right = isSumTreeHelper(node.right);
        if (right < 0) {
            return -1;
        }
        if (left == 0 && right == 0) {  // leaf node return itself val
            return node.val;
        }
        if (node.val == left + right) { // if not a leaf node, shouuld satisfy this one.
            return node.val * 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(26);
        TreeNode t2 = new TreeNode(10);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(6);
        TreeNode t6 = new TreeNode(3);
        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5;
        t3.right = t6;
        System.out.println(isSumTree(t1));
    }

}
