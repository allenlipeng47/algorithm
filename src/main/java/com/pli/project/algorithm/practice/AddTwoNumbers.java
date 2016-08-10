package com.pli.project.algorithm.practice;


import com.pli.project.algorithm.leetcode.ListNode;

/**
 * Created by lipeng on 2016/8/10.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1), curr = dummyHead;
        int carrier = 0;
        while (l1 != null || l2 != null || carrier != 0) {
            int num = 0;
            if (l1 != null) {
                num += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num += l2.val;
                l2 = l2.next;
            }
            num += carrier;
            curr.next = new ListNode(num - num / 10 * 10);
            carrier = num / 10;
            curr = curr.next;
        }
        return dummyHead.next;
    }
}
