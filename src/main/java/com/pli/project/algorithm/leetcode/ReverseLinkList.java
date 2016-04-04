package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/3/25.
 */
public class ReverseLinkList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            head = next;
        }
        return pre;
    }

}
