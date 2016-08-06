package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/8/6.
 * https://leetcode.com/problems/partition-list/
 * Maintain two lists, less and great.
 * Put the element which is less than x to less list.
 * Put element which is greater than or equal to x to great list.
 */
public class l86PartitionListII {

    public static ListNode partition2(ListNode head, int x) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode less = dummyHead, greater = dummyHead;
        while (greater.next != null && greater.next.val < x) {
            greater = greater.next;
        }
        less = greater;
        while (greater.next != null) {
            if (greater.next.val >= x) {
                greater = greater.next;
                continue;
            }
            ListNode curr = greater.next;
            greater.next = curr.next;
            curr.next = less.next;
            less.next = curr;
            less = curr;
        }
        return dummyHead.next;
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1), great = new ListNode(-1), currLess = less, currGreat = great;
        while (head != null) {
            if (head.val < x) {
                currLess.next = head;
                currLess = currLess.next;
            }
            else {
                currGreat.next = head;
                currGreat = currGreat.next;
            }
            head = head.next;
        }
        currLess.next = great.next;
        currGreat.next = null;
        return currLess.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
//        ListNode l4 = new ListNode(1);
//        ListNode l5 = new ListNode(2);
//        ListNode l6 = new ListNode(3);
        l1.next = l2; l2.next = l3; // l3.next = l4; l4.next = l5; l5.next = l6;
        ListNode l = partition2(l1, 3);
        System.out.println(l);

    }

}
