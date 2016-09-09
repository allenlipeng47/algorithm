package com.pli.project.algorithm.practice;

import com.pli.project.algorithm.leetcode.ListNode;

/**
 * Created by lipeng on 2016/9/8.
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseKthGroupNodes {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1), front = head;
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < k && front != null; i++, front = front.next);
        while (front != null) {
            ListNode tail = head.next, curr = tail.next;
            front = front == null ? null : front.next;
            for (int i = 1; i < k; i++) {
                tail.next = curr.next;
                curr.next = head.next;
                head.next = curr;
                curr = tail.next;
                front = front == null ? null : front.next;
            }
            head = tail;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        l1.next = l2; l2.next = l3; l3.next = l4; l4.next = l5; l5.next = l6; l6.next = l7; l7.next = l8;
        ReverseKthGroupNodes r = new ReverseKthGroupNodes();
        System.out.println(reverseKGroup(l1, 3));
    }

}
