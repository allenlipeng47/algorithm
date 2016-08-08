package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/8/7.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class l82RemoveDuplicateFromSortedListII {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val != curr.next.next.val) {
                curr = curr.next;
                continue;
            }
            int val = curr.next.val;
            while (curr.next != null && curr.next.val == val) {
                curr.next = curr.next.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(5);
        l1.next = l2; l2.next = l3; l3.next = l4; l4.next = l5; l5.next = l6; l6.next = l7;
        System.out.println(deleteDuplicates(l1));
    }

}
