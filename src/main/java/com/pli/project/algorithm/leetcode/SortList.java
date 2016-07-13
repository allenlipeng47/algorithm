package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/7/12.
 * https://leetcode.com/problems/sort-list/
 */
public class SortList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        public String toString() {
            if (next == null) {
                return String.valueOf(val);
            }
            else {
                return String.valueOf(val) + "->" + next;
            }
        }
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        head = sortList(head);
        slow = sortList(slow);
        // merge head and slow
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        while (head != null && slow != null) {
            if (head.val < slow.val) {
                curr.next = head;
                head = head.next;
            }
            else {
                curr.next = slow;
                slow = slow.next;
            }
            curr = curr.next;
        }
        if (head == null) {
            curr.next = slow;
        }
        else {
            curr.next = head;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(6);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(4);
        l1.next = l2; l2.next = l3; l3.next = l4; l4.next = l5; l5.next = l6;
        System.out.println(sortList(l1));

    }


}
