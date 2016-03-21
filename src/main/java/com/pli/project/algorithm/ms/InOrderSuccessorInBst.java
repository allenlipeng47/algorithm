package com.pli.project.algorithm.ms;

import com.pli.project.algorithm.util.TreeNode;

/**
 * Created by lipeng on 2016/3/17.
 */
public class InOrderSuccessorInBst {

    public static TreeNode findBstSuccessor(TreeNode root, int val) {
        TreeNode[] successor = new TreeNode[1];
        findBstSuccessorHelper(root, val, successor);
        return successor[0];
    }

    public static void findBstSuccessorHelper(TreeNode root, int val, TreeNode[] successor) {
        if (root == null) {
            successor = null;
            return;
        }
        if (val < root.val) {
            successor[0] = root;
            findBstSuccessorHelper(root.left, val, successor);
        }
        else {
            findBstSuccessorHelper(root.right, val, successor);
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
        TreeNode t9 = new TreeNode(9);
        t9.left = t8;
        t8.left = t2;
        t2.right = t3;
        t3.left = t1; t3.right = t5;
        t5.left = t4; t5.right = t6;
        TreeNode successor = findBstSuccessor(t9, 2);
        if (successor == null) {
            System.out.println(successor);
        }
        else {
            System.out.println(successor.val);
        }
    }

    public static void test1() {
        TreeNode t0 = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        t5.left = t2; t5.right = t8;
        t2.left = t1; t2.right = t4;
        t4.left = t3;
        t8.left = t6; t8.right = t9;
        t6.right = t7;
        t1.left = t0;
        TreeNode successor = findBstSuccessor(t5, 0);
        if (successor == null) {
            System.out.println(successor);
        }
        else {
            System.out.println(successor.val);
        }
    }
}
