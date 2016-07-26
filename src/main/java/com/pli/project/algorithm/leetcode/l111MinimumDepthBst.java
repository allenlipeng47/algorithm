package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/7/26.
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Solutin is to traverse all the leaf node. When reach a leaf node, update ans with the currDept
 */
public class l111MinimumDepthBst {

    private int ans = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;
        helper(root, 1, ans);
        return ans[0] == Integer.MAX_VALUE ? 0 : ans[0];
    }

    private void helper(TreeNode root, int currDepth, int[] ans) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans[0] = Math.min(ans[0], currDepth);
        }
        helper(root.left, currDepth + 1, ans);
        helper(root.right, currDepth + 1, ans);
    }

}
