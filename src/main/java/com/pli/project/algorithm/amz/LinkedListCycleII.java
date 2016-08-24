package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.leetcode.ListNode;

/**
 * Created by lipeng on 2016/8/23.
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow == fast);
        while (head != slow) {
            slow = slow.next;
            head = head.next;
        }
        return slow;
    }

}
