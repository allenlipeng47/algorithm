package com.pli.project.algorithm.leetcode;

import java.util.LinkedList;

/**
 * Created by lipeng on 2016/7/13.
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {

    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        // find the 2nd half. 2nd half should be equal to or less than first half
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode preSlow = slow;
        slow = slow.next;
        preSlow.next = null;
        // reverse slow
        ListNode dummyHead = new ListNode(0);
        while (slow != null) {
            preSlow = slow;
            slow = slow.next;
            preSlow.next = dummyHead.next;
            dummyHead.next = preSlow;
        }
        slow = dummyHead.next;
        // merge head and slow
        ListNode currLeft = head;
        while (slow != null) {
            preSlow = slow;
            slow = slow.next;
            preSlow.next = currLeft.next;
            currLeft.next = preSlow;
            currLeft = preSlow.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);
//        ListNode l6 = new ListNode(6);
        l1.next = l2; //l2.next = l3; l3.next = l4; l4.next = l5; l5.next = l6;
        reorderList(l1);
        System.out.println(l1);
    }

}
