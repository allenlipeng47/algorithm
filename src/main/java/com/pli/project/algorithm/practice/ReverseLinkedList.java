package com.pli.project.algorithm.practice;

import com.pli.project.algorithm.leetcode.ListNode;

/**
 * Created by lipeng on 2016/8/10.
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(-1), curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = dummyHead.next;
            dummyHead.next = curr;
            curr = next;
        }
        return dummyHead.next;
    }

}
