package com.pli.project.algorithm.practice;

import com.pli.project.algorithm.leetcode.ListNode;

/**
 * Created by lipeng on 2016/8/12.
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
