package com.pli.project.algorithm.ms;

import com.pli.project.algorithm.util.TreeNode;

import java.util.Stack;

/**
 * Created by lipeng on 2016/3/19.
 */
public class FlattenBst {

    public void flattenBst(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        loadRight(stack, root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            loadRight(stack, node.left);
            node.right = pre;
            node.left = null;
            pre = node;
        }
        root = pre;
    }

    private void loadRight(Stack<TreeNode> stack, TreeNode root) {
        while (root != null) {
            stack.add(root);
            root = root.right;
        }
    }

    private TreeNode next;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = next;
        root.left = null;
        next = root;
    }

    public static void main(String[] args) {
//        TreeNode t1 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(2);
//        t1.right = t2;
//        FlattenBst flattenBst = new FlattenBst();
//        flattenBst.flatten(t1);
//        System.out.println();
        test1();
    }

    public static void test1() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2; t1.right = t5;
        t2.left = t3; t2.right = t4;
        FlattenBst flattenBst = new FlattenBst();
        flattenBst.flatten(t1);
        System.out.println();
    }

}
