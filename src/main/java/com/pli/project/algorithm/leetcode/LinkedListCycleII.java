package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/7/14.
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        while (head != fast) {
            head = head.next;
            fast = fast.next;
        }
        return head;
    }


}
