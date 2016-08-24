package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.leetcode.ListNode;

/**
 * Created by lipeng on 2016/8/23.
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        do {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        return true;
    }

}
