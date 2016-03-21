package com.pli.project.algorithm.ms;

import com.pli.project.algorithm.util.TreeNode;

import java.util.Stack;

/**
 * Created by lipeng on 2016/3/17.
 * Inorder traverse binary tree without putting null.
 */
public class InOrderTraversal {

    public static void inOrderTraverse(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        putAllLeft(stack, root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            System.out.println(curr.val);
            putAllLeft(stack, curr.right);
        }
    }

    public static void putAllLeft(Stack<TreeNode> stack, TreeNode root) {
        while (root != null) {
            stack.add(root);
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
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5;
        t3.left = t7; t3.right = t8;
        t4.left = t6;
        inOrderTraverse(t1);
    }


}
