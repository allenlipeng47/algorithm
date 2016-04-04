package com.pli.project.algorithm.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lipeng on 2016/1/18.
 * http://www.cnblogs.com/jcliBlogger/p/4771342.html
 * Solution is to maintain a k size window. When it reaches the closest k elements, diff should reach the minimum.
 */
public class FindClosestKNode {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        closestKValuesHelper(root, target, k, list);
        return list;
    }

    public static void closestKValuesHelper(TreeNode root, double target, int k, LinkedList<Integer> list) {
        if (root == null)
            return;
        closestKValuesHelper(root.left, target, k, list);
        if (list.size() < k)    // keep adding element when size hasn't reach k
            list.add(root.val);
        else {
            // diff measure how big difference the window is different from the target val
            // moving from small to greater, the diff should be smaller. Until it passes the proper position
            double currDiff = Math.max(Math.abs(list.getLast() - target), Math.abs(list.getFirst() - target));
            double nextDiff = Math.max(Math.abs(list.get(1) - target), Math.abs(root.val - target));
            if (nextDiff > currDiff)
                return;
            list.addLast(root.val);
            list.remove(0);
        }
        closestKValuesHelper(root.right, target, k, list);
    }

    public static void main(String[] args) {
        TreeNode t10 = new TreeNode(10);
        TreeNode t5 = new TreeNode(5);
        TreeNode t15 = new TreeNode(15);
        TreeNode t3 = new TreeNode(3);
        TreeNode t7 = new TreeNode(7);
        TreeNode t13 = new TreeNode(13);
        TreeNode t18 = new TreeNode(18);
        TreeNode t1 = new TreeNode(1);
        TreeNode t4 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        TreeNode t8 = new TreeNode(8);
        TreeNode t12 = new TreeNode(12);
        TreeNode t14 = new TreeNode(14);
        TreeNode t16 = new TreeNode(16);
        TreeNode t20 = new TreeNode(20);
        TreeNode t9 = new TreeNode(9);
        TreeNode t11 = new TreeNode(11);
        TreeNode t19 = new TreeNode(19);
        t10.left = t5; t10.right = t15;
        t5.left = t3; t5.right = t7;
        t15.left = t13; t15.right = t18;
        t3.left = t1; t3.right = t4;
        t7.left = t6; t7.right = t8;
        t13.left = t12; t13.right = t14;
        t18.left = t16; t18.right = t20;
        t8.right = t9;
        t12.left = t11;
        t20.left = t19;
        List<Integer> list = closestKValues(t10, (double)7.5, 100);
        System.out.println(list);

    }
}
