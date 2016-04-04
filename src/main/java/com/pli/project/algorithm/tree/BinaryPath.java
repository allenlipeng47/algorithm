package com.pli.project.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/1/24.
 */
public class BinaryPath {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static ArrayList<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list = new ArrayList<String>();
        binaryTreePathsHelper(root, list, "");
        return list;
    }

    public static void binaryTreePathsHelper(TreeNode root, ArrayList<String> list, String ans) {
        if (root == null)
            return;
        ans += String.valueOf(root.val);
        if (root.left == null && root.right ==null) {
            list.add(ans);
            return;
        }
        ans += "->";
        binaryTreePathsHelper(root.left, list, ans);
        binaryTreePathsHelper(root.right, list, ans);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5;
        ArrayList<String> list = binaryTreePaths(t1);
        System.out.println(list);
    }
}
