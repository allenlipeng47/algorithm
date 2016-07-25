package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/7/24.
 * https://leetcode.com/problems/add-two-numbers/
 */
public class l2AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1), curr = dummyHead;
        int carrier = 0;
        while (l1 != null && l2 != null) {
            int num = l1.val + l2.val + carrier;
            curr.next = new ListNode(num % 10);
            carrier = num / 10;
            l1 = l1.next;
            l2 = l2.next;
            curr = curr.next;
        }
        l1 = l1 == null ? l2 : l1;
        while (l1 != null) {
            int num = l1.val + carrier;
            curr.next = new ListNode(num % 10);
            carrier = num / 10;
            l1 = l1.next;
            curr = curr.next;
        }
        if (carrier != 0) {
            curr.next = new ListNode(1);
        }
        return dummyHead.next;
    }

}
