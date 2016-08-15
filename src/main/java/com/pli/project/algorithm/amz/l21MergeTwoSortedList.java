package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.leetcode.ListNode;

/**
 * Created by lipeng on 2016/8/14.
 */
public class l21MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1), curr = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        else {
            curr.next = l2;
        }
        return dummyHead.next;
    }

}
