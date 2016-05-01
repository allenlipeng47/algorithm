package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/4/30.
 */
public class OddEvenList2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head, even = head.next;
        while (even.next != null) {
            ListNode nextCurr = even.next.next;
            even.next.next = odd.next;
            odd.next = even.next;
            even.next = nextCurr;
            if (nextCurr == null) {
                break;
            }
            odd = odd.next;
            even = nextCurr;
        }
        return head;
    }

}
