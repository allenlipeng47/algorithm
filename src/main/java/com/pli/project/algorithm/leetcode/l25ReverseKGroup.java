package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/9/1.
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * General process is similar to http://www.allenlipeng47.com/blog/index.php/2016/08/04/reverse-linked-list-ii/
 * Create a front node, to test if next loop(head, tail, curr) is durable.
 */
public class l25ReverseKGroup {

    // 1->2->3->4->5->6->7->8->9->10, 4, will return 4->3->2->1->8->7->6->-5>->9->10
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0), front = head;
        dummy.next = head;
        head = dummy;
        for (int i = 0; i < k && front != null; i++) {
            front = front.next;
        }
        while (front != null && head != null && head.next != null) {
            ListNode tail = head.next, curr = tail.next;
            for (int i = 1; i < k; i++) {
                tail.next = curr.next;
                curr.next = head.next;
                head.next = curr;
                curr = tail.next;
                front = front == null ? null : front.next;
            }
            head = tail;
        }
        return dummy.next;
    }

    // 1->2->3->4->5->6->7->8->9->10, 4, will return 4->3->2->1->8->7->6->-5>->10->9
    public static ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head != null && head.next != null) {
            ListNode tail = head.next, curr = tail.next;
            for (int i = 1; i < k && curr != null; i++) {
                tail.next = curr.next;
                curr.next = head.next;
                head.next = curr;
                curr = tail.next;
            }
            head = tail;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(10);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6;
        n6.next = n7; n7.next = n8; n8.next = n9; n9.next = n10;
        System.out.println(reverseKGroup(n1, 4));
    }

}
