package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/7/26.
 * https://leetcode.com/problems/path-sum/
 */
public class l112SumPath {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            return true;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }




}
