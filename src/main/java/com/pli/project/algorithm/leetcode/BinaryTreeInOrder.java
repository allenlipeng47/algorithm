package com.pli.project.algorithm.leetcode;

import com.pli.project.algorithm.util.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lipeng on 2016/7/13.
 */
public class BinaryTreeInOrder {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        pushAll(root, stack);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            ans.add(curr.val);
            pushAll(curr.right, stack);
        }
        return ans;
    }

    public static void pushAll(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2; t1.right = t4;
        t2.right = t3;
        t4.left = t5; t4.right = t6;
        System.out.println(inorderTraversal(t1));
    }

}
