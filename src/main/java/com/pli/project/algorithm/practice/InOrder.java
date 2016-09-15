package com.pli.project.algorithm.practice;

import com.pli.project.algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lipeng on 2016/9/14.
 */
public class InOrder {

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        loadLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            ans.add(curr.val);
            loadLeft(curr.right, stack);
        }
        return ans;
    }

    private void loadLeft(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

}
