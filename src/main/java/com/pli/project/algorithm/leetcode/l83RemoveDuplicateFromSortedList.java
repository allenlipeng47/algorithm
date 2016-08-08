package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/8/7.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class l83RemoveDuplicateFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.next.val == curr.val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }

}
