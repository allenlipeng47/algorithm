package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/8/16.
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        helper(root, list, 0);
        return list;
    }

    private void helper(TreeNode root, List<List<Integer>> list, int level) {
        if (root == null) {
            return;
        }
        if (level == list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        helper(root.left, list, level + 1);
        helper(root.right, list, level + 1);
    }

}
