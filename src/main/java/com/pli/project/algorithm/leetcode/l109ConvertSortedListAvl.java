package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/7/26.
 */
public class l109ConvertSortedListAvl {

    // O(nlogn) solution
    public static TreeNode sortedListToBST2(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head, fast = head.next; // pivot should be slow.next. In this way, it is easy to set slow.next = null
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.next.val);    // pivot is slow.next
        ListNode next = slow.next.next;
        slow.next = null; // cut the list.
        node.left = sortedListToBST2(head);
        node.right = sortedListToBST2(next);
        return node;
    }

    // O(n) time, O(logN) solution.
    // count number of ListNode, then divide n into 3 parts. And recursively build the AVL tree
    // for 1, 2, 3, 4, 5, 6. mid = 4, left = [1, 2, 3], right = [5, 6]
    // for 1, 2, 3, 4, 5, 6, 7. mid = 4, left = [1, 2, 3], right = [5, 6, 7]
    private ListNode head = null;

    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        int n = 0;
        ListNode node = head;
        while (node != null) {
            n++;
            node = node.next;
        }
        return helper(n);
    }

    private TreeNode helper(int n) {
        if (n <= 0) {
            return null;
        }
        int mid = n >> 1;
        TreeNode left = helper(mid);    // left part
        TreeNode node = new TreeNode(head.val);
        head = head.next;
        node.left = left;
        node.right = helper(n - mid - 1);   // right part
        return node;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(8);
        l1.next = l2; l2.next = l3;;
        TreeNode node = sortedListToBST2(l1);
        System.out.println();

    }

}
