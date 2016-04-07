package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/4/6.
 */
public class RemoveLInkedListElement {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0), pre = dummyHead;
        dummyHead.next = head;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
            }
            else {
                pre = head;
            }
            head = head.next;
        }
        return dummyHead.next;
    }

}
