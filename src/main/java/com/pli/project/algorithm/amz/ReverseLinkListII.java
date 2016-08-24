package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.leetcode.ListNode;

/**
 * Created by lipeng on 2016/8/23.
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {    // 1. Make sure at least 2 nodes
            return head;
        }
        ListNode dummyHead = new ListNode(0), revHead = dummyHead;
        dummyHead.next = head;
        for (int i = 1; i < m && revHead.next != null; i++) {   // let revHead keep going
            revHead = revHead.next;
        }
        if (revHead.next == null || revHead.next.next == null) {    // Make sure revHead at least has one next Node
            return head;
        }
        ListNode revTail = revHead.next, curr = revHead.next.next;
        revTail.next = null;
        for (int i = 0; i < n - m && curr != null; i++) {   // let curr keeps going
            ListNode tmp = curr.next;
            curr.next = revHead.next;
            revHead.next = curr;
            curr = tmp;
        }
        revTail.next = curr;
        return dummyHead.next;
    }

}
