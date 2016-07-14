package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/7/13.
 * https://leetcode.com/problems/insertion-sort-list/
 */
public class InsertionSortList {

    public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        while (head != null) {
            // take out head to curr. head move to next
            ListNode curr = head;
            head = head.next;
            // put curr to target position in dummyHead. Put curr between target and target.next
            ListNode target = dummyHead;
            while (target.next != null && target.next.val < curr.val) {
                target = target.next;
            }
            curr.next = target.next;
            target.next = curr;
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
        System.out.println(insertionSortList(l1));
    }

}
