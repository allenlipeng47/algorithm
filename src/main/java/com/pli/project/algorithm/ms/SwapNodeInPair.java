package com.pli.project.algorithm.ms;

/**
 * Created by lipeng on 2016/3/19.
 */
public class SwapNodeInPair {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public String toString() {
            if (next == null) {
                return String.valueOf(val);
            }
            else {
                return String.valueOf(val) + "->" + next;
            }
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;
        while (head != null && head.next != null) {
            ListNode secondNode = head.next;
            head.next = secondNode.next;
            secondNode.next = head;
            pre.next = secondNode;
            pre = head;
            head = pre.next;
        }
        if (pre == dummyHead) {
            return head;
        }
        else {
            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2; l2.next = l3; l3.next = l4; l4.next = l5;
        ListNode ans = swapPairs(l1);
        System.out.println(ans);
    }
}
