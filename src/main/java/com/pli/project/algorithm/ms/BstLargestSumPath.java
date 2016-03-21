package com.pli.project.algorithm.ms;

import com.pli.project.algorithm.util.TreeNode;

/**
 * Created by lipeng on 2016/3/19.
 */
public class BstLargestSumPath {

    // when only considering positive values
    public int maxPathSum2(TreeNode root) {
        int[] ans = new int[2];
        maxPathSumHelper2(root, ans);
        return ans[1];
    }

    // ans[] = {path including current node, path inside this tree}
    public void maxPathSumHelper2(TreeNode root, int[] ans) {
        if (root == null) {
            return;
        }
        int[] left = new int[2];
        int[] right = new int[2];
        left[1] = right[1] = Integer.MIN_VALUE;
        maxPathSumHelper2(root.left, left);
        maxPathSumHelper2(root.right, right);
        ans[0] = root.val + Math.max(Math.max(left[0], right[0]), 0);
        ans[1] = Math.max(Math.max(left[0], 0) + Math.max(right[0], 0) + root.val, Math.max(left[1], right[1]));
    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathHelper(root);
        return max;
    }

    // this method only returns the max path including root. It doesn't go up and down.
    // During each iteration , update max value. Doesn't return it.
    public int maxPathHelper(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int left = maxPathHelper(root.left);
        left = Math.max(left, 0);
        int right = maxPathHelper(root.right);
        right = Math.max(right, 0);
        max = Math.max(max, root.val + left + right);
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        BstLargestSumPath test = new BstLargestSumPath();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2; t1.right = t3;
        System.out.println(test.maxPathSum(t1));
    }

    public static void test1() {
        BstLargestSumPath test = new BstLargestSumPath();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(-10);
        TreeNode t8 = new TreeNode(-10);
        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5;
        t3.left = t6;
        t4.left = t7; t4.right = t8;
        System.out.println(test.maxPathSum2(t1));
    }


}
