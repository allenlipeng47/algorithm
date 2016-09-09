package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/9/8.
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class l117NextRightPointer {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
        public String toString() {return String.valueOf(val);}
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(-1), pre = dummy;
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if (root == null) {
                root = dummy.next;
                dummy.next = null;
                pre = dummy;
            }
        }
    }

}
