package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.leetcode.ListNode;
import org.junit.Test;

/**
 * Created by lipeng on 2016/8/23.
 */
public class ReverseLinkListIITest {

    @Test
    public void test1() {
        ReverseLinkListII r = new ReverseLinkListII();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        l1.next = l2; l2.next = l3; l3.next = l4; l4.next = l5; l5.next = l6; l6.next = l7;
        ListNode ans = r.reverseBetween(l1, 5, 8);
        System.out.println(ans);
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0), revHead = dummyHead;
        dummyHead.next = head;
        for (int i = 1; i < m && revHead.next != null; i++) {
            revHead = revHead.next;
        }
        if (revHead.next == null | revHead.next.next == null) {
            return head;
        }
        ListNode revTail = revHead.next, curr = revHead.next.next;
        revTail.next = null;
        for (int i = 0; i < m - n && curr != null; i++) {
            ListNode tmp = curr.next;
            curr.next = revHead.next;
            revHead.next = curr;
            curr = tmp;
        }
        revTail.next = curr;
        return dummyHead.next;
    }

}
