package com.pli.project.algorithm.tree;

import com.pli.project.algorithm.util.TreeNode;

/**
 * Created by lipeng on 2016/3/14.
 */
public class HouseRobberIII {

    public int rob(TreeNode root) {
        return Math.max(robHelper(root, true), robHelper(root, false));
    }

    public int robHelper(TreeNode root, boolean canRob) {
        if (root == null) {
            return 0;
        }
        int robLeft = robHelper(root.left, true);
        int robRight = robHelper(root.right, true);
        if (!canRob) {
            return robLeft + robRight;
        }
        int noRobLeft = robHelper(root.left, false);
        int noRobRight = robHelper(root.right, false);
        return Math.max(root.val + noRobLeft + noRobRight, robLeft + robRight);
    }

}
