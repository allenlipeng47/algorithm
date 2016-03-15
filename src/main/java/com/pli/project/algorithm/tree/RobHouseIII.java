package com.pli.project.algorithm.tree;

import com.pli.project.algorithm.util.TreeNode;

/**
 * Created by lipeng on 2016/3/14.
 * https://leetcode.com/problems/house-robber-iii/
 */
public class RobHouseIII {

    public static int rob(TreeNode root) {
        int[] num = new int[2];
        robHelper(root, num);
        return Math.max(num[0], num[1]);
    }

    // nums[0] is the max val when rob root. nums[1] is the max val when not rob root
    public static void robHelper(TreeNode root, int[] nums) {
        if (root == null) {
            nums[0] = 0;
            nums[1] = 0;
            return;
        }
        int[] left = new int[2], right = new int[2];
        robHelper(root.left, left);
        robHelper(root.right, right);
        nums[0] = root.val + left[1] + right[1];
        nums[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(1);
        t1.left = t2; t1.right = t3;
        t2.right = t4; t3.right = t1;
        System.out.println(rob(t1));
    }

}
