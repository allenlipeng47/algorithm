package com.pli.project.algorithm.practice;

import com.pli.project.algorithm.leetcode.ListNode;
import org.junit.Test;

/**
 * Created by lipeng on 2016/8/12.
 */
public class LinkedListCycleIITest {

    @Test
    public void test1() {
        ListNode l1 = new ListNode(1);
        l1.next = l1;
        LinkedListCycleII l = new LinkedListCycleII();
        assert l.detectCycle(l1) == l1;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
