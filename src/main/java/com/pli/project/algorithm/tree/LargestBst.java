package com.pli.project.algorithm.tree;

import javafx.util.Pair;

/**
 * Created by lipeng on 2016/2/17.
 * http://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
 */
public class LargestBst {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int largestBst(TreeNode node) {
        return Math.abs(largestBstHelper(node).ans);
    }

    public static class Triplet {
        int max, min, ans;
        public Triplet (int max, int min, int ans) {
            this.max = max;
            this.min = min;
            this.ans = ans;
        }
    }

    /**
     * The idea is that return the (max, min) val from left subtree, (max, min) val from right subtree.
     * Node is a valid bst if left.max < node.val and right.min > node.val
     * If triplet.ans is negative, it means subtree is invalid already. The answer from sub tree is abs(triplet.ans) */
    public static Triplet largestBstHelper(TreeNode node) {
        if (node == null) {
            return new Triplet(0, 0, 0);
        }
        Triplet left = largestBstHelper(node.left);
        Triplet right = largestBstHelper(node.right);
        // left subtree is not valid because either left subtree is no more a BST, or left.max is greater than node.val
        boolean leftInvalid = left.ans < 0 || (left.ans > 0 && left.max >= node.val);
        // right subtree is not valid because either right subtree is no more a BST, or right.min is less than node.val
        boolean rightInvalid = right.ans < 0 || (right.ans > 0 && right.min <= node.val);
        if (leftInvalid || rightInvalid) {
            return new Triplet(Math.max(left.max, right.max), Math.min(left.min, right.min), -Math.max(Math.abs(left.ans), Math.abs(right.ans)));
        }
        int min = (node.left == null) ? node.val : left.min;  // if left node is null, should use node.val
        int max = (node.right == null) ? node.val : right.max;    // if right node is null, should use node.val
        return new Triplet(max, min, left.ans + right.ans + 1);
    }

    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5;
        System.out.println(largestBst(t1));
    }

    public static void test2() {
        TreeNode t1 = new TreeNode(50);
        TreeNode t2 = new TreeNode(30);
        TreeNode t3 = new TreeNode(60);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(20);
        TreeNode t6 = new TreeNode(45);
        TreeNode t7 = new TreeNode(70);
        TreeNode t8 = new TreeNode(65);
        TreeNode t9 = new TreeNode(80);
        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5;
        t3.left = t6; t3.right = t7;
        t7.left = t8; t7.right = t9;
        System.out.println(largestBst(t1));
    }
}
