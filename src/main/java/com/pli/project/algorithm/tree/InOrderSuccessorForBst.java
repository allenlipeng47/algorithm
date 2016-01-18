package com.pli.project.algorithm.tree;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Stack;

/**
 * Created by lipeng on 2016/1/17.
 */
public class InOrderSuccessorForBst {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        public String toString() {
            return String.valueOf(val);
        }
    }

    // by stack
    public static TreeNode nextSuccessor(TreeNode node, TreeNode target) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(node);
        TreeNode curr;
        boolean found = false;
        while (!s.isEmpty()) {
            while ((curr = s.peek()) != null)
                s.push(curr.left);
            s.pop();    // pop null value;
            if (!s.isEmpty()) {
                curr = s.pop();
                if (found)
                    return curr;
                if (curr == target)
                    found = true;
                s.push(curr.right);
            }
        }
        return null;
    }

    // recursive way
    public static TreeNode nextSuccessor2(TreeNode node, TreeNode target) {
        boolean[] found = new boolean[1];
        return nextSuccessor2Helper(node, target, found);
    }

    public static TreeNode nextSuccessor2Helper(TreeNode node, TreeNode target, boolean[] found) {
        if (node == null)
            return null;
        TreeNode curr = nextSuccessor2Helper(node.left, target, found);
        if (curr !=null)
            return curr;
        if (found[0] == true)
            return node;
        if(node == target)
            found[0] = true;
        curr = nextSuccessor2Helper(node.right, target, found);
        if (curr != null)
            return curr;
        return null;
    }

    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5;
        t3.left = t6; t3.right = t7;
        t6.left = t8; t8.right = t9;
        System.out.println(nextSuccessor(t1, t1));
    }

    public static void test2() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5;
        t3.left = t6; t3.right = t7;
        t6.left = t8; t8.right = t9;
        System.out.println(nextSuccessor(t1, t7));
    }

}
