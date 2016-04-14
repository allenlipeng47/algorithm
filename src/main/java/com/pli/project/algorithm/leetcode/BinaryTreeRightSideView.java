package com.pli.project.algorithm.leetcode;

import com.pli.project.algorithm.tree.BinaryIndexedTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lipeng on 2016/4/10.
 */
public class BinaryTreeRightSideView {



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int maxDepth;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        maxDepth = 0;
        helper(root, 1, ans);
        return ans;
    }

    private void helper(TreeNode root, int currDepth, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (currDepth > maxDepth) {
            maxDepth = currDepth;
            ans.add(root.val);
        }
        helper(root.right, currDepth + 1, ans);
        helper(root.left, currDepth + 1, ans);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2; t1.right = t3;
        t2.left = t4;
        t3.left = t5;
        t4.left = t6;
        BinaryTreeRightSideView b = new BinaryTreeRightSideView();
        List<Integer> ans = b.rightSideView(t1);
        System.out.println(ans);
    }

}
