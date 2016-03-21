package com.pli.project.algorithm.ms;

/**
 * Created by lipeng on 2016/3/19.
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class NextRightPointer {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
        public String toString() {return String.valueOf(val);}
    }

    private void connectHelper2(TreeLinkNode root, TreeLinkNode parentSibling) {
        if (root == null) {
            return;
        }
        TreeLinkNode sibling = getNextSibling(parentSibling);
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = sibling;
            connectHelper2(root.left, root.right);
            connectHelper2(root.right, sibling);
        }
        else if (root.left != null) {
            root.left.next = sibling;
            connectHelper2(root.left, sibling);
        }
        else if (root.right != null) {
            root.right.next = sibling;
            connectHelper2(root.right, sibling);
        }
    }

    private TreeLinkNode getNextSibling(TreeLinkNode parentSibling) {
        while(parentSibling != null) {
            if (parentSibling.left != null) {
                return parentSibling.left;
            }
            if (parentSibling.right != null) {
                return parentSibling.right;
            }
            parentSibling = parentSibling.next;
        }
        return null;
    }

    // superior version. Use dummyHead to remove else judgement.
    public static void connect2(TreeLinkNode root) {
        TreeLinkNode dummyHead = new TreeLinkNode(0);
        TreeLinkNode pre = dummyHead;
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left;
                pre = root.left;
            }
            if (root.right != null) {
                pre.next = root.right;
                pre = root.right;
            }
            root = root.next;
            if (root == null) {
                root = dummyHead.next;
                pre = dummyHead;
                dummyHead.next = null;
            }
        }
    }

    // traditional version.
    public static void connect(TreeLinkNode root) {
        TreeLinkNode head = null, pre = null;
        while (root != null) {
            if (root.left != null) {
                if (pre != null) {
                    pre.next = root.left;
                    pre = root.left;
                }
                else {
                    head = pre = root.left;
                }
            }
            if (root.right != null) {
                if (pre != null) {
                    pre.next = root.right;
                    pre = root.right;
                }
                else {
                    head = pre = root.right;
                }
            }
            root = root.next;
            if (root == null) {
                root = head;
                head = pre = null;
            }
        }
    }

    public static void main(String[] args) {
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n7 = new TreeLinkNode(7);
        TreeLinkNode n8 = new TreeLinkNode(8);
        TreeLinkNode n9 = new TreeLinkNode(9);
        TreeLinkNode n10 = new TreeLinkNode(10);
        TreeLinkNode n11 = new TreeLinkNode(11);
        TreeLinkNode n12 = new TreeLinkNode(12);
        TreeLinkNode n13 = new TreeLinkNode(13);
        n1.left = n2; n1.right = n3;
        n2.left = n4; n2.right = n5;
        n3.left = n6; n3.right = n7;
        n4.left = n8; n4.right = n9;
        n6.left = n10; n6.right = n11;
        n7.left = n12; n7.right = n13;
        connect(n1);
    }

}
