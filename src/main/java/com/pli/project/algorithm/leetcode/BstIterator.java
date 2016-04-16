package com.pli.project.algorithm.leetcode;

import com.pli.project.algorithm.util.TreeNode;

import java.util.Stack;

/**
 * Created by lipeng on 2016/4/16.
 */
public class BstIterator {

    Stack<TreeNode> s;

    public BstIterator(TreeNode root) {
        s = new Stack<>();
        loadLeft(root);
    }

    private void loadLeft(TreeNode root) {
        while (root != null) {
            s.add(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curr = s.pop();
        loadLeft(curr.right);
        return curr.val;
    }
}