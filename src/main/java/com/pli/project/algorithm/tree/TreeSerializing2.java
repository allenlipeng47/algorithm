package com.pli.project.algorithm.tree;

import java.util.ArrayList;

/**
 * Created by lipeng on 2015/8/1.
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * Use recursive way to do serializing and deserializing
 */
public class TreeSerializing2 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuffer ans = new StringBuffer();
        serializeHelper(root, ans);
        return ans.substring(1, ans.length());
    }

    public static void serializeHelper(TreeNode root, StringBuffer ans) {
        if(root == null) {
            ans.append(",null");
            return;
        }
        ans.append("," + root.val);
        serializeHelper(root.left, ans);
        serializeHelper(root.right, ans);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] elems = data.split(",");
        ArrayList<String> list = new ArrayList<String>();
        for(String ele : elems)
            list.add(ele);
        return deserializeHelper(list);
    }

    public static TreeNode deserializeHelper(ArrayList<String> list) {
        if(list.size() == 0)
            return null;
        String ele = list.remove(0);
        if(ele.equals("null"))
            return null;
        TreeNode tree = new TreeNode(Integer.valueOf(ele));
        tree.left = deserializeHelper(list);
        tree.right = deserializeHelper(list);
        return tree;
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
        t2.left = t4;
        t3.left = t5; t5.right = t6;
        t6.left = t7; t6.right = t8;
        String seralized = serialize(t1);
        System.out.println(seralized);
        TreeNode tree = deserialize(seralized);
        System.out.println();
    }

}
