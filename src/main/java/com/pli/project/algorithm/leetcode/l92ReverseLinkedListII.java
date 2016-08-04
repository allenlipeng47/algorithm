package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/8/3.
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class l92ReverseLinkedListII {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode start = dummyHead;
        for (int i = 1; i < m; i++) {
            start = start.next;
        }
        ListNode pre = start.next, curr = start.next.next;
        for (int i = 1; i <= n - m; i++) {
            pre.next = curr.next;
            curr.next = start.next;
            start.next = curr;
            curr = pre.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(5);
        n1.next = n2;
        ListNode ans = reverseBetween(n1, 1, 2);
        System.out.println(ans);
    }

}
