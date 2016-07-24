package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/7/24.
 */
public class l129SumRootToLeafNumbers {

    public static int sumNumbers(TreeNode root) {
        int[] ans = new int[1];
        helper(root, 0, ans);
        return ans[0];
    }

    private static void helper(TreeNode root, int curr, int[] total) {
        if (root == null) {
            return;
        }
        curr = curr * 10 + root.val;
        if (root.left == null && root.right == null) {
            total[0] += curr;
        }
        helper(root.left, curr, total);
        helper(root.right, curr, total);
    }

    public static void main(String[] args) {

    }

}
