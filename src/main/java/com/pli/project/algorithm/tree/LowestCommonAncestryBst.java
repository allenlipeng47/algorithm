package com.pli.project.algorithm.tree;

/**
 * Created by lipeng on 2016/1/30.
 */
public class LowestCommonAncestryBst {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        if (root.val >= min && root.val <= max) {
            return root;
        }
        return root.val > max ? lowestCommonAncestor(root.left, p, q) : lowestCommonAncestor(root.right, p, q);
    }

    public static void main(String[] args) {
        test2();
//        int[] nums = {1, 2, 3, 4};
    }

    public static void test1() {
        TreeNode t4 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t5 = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        t4.left = t2; t4.right = t5;
        t2.left = t1; t2.right = t3;
        TreeNode ans = lowestCommonAncestor(t4, t1, t2);
        System.out.println(ans.val);
    }

    public static void test2() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.right = t2;
        TreeNode ans = lowestCommonAncestor(t1, t2, t1);
        System.out.println(ans.val);
    }
}
