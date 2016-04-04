package com.pli.project.algorithm.list;

/**
 * Created by lipeng on 2016/1/16.
 * Swap the near elements
 * Given a list a->b->c->d->e->f
 * Return a->c->b->e->d->f
 */
public class SwapNear {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        public String toString() {
            if(next == null)
                return String.valueOf(val);
            else
                return val + "->" + next;
        }
    }

    public static ListNode swapNear(ListNode head) {
        if(head == null)
            return null;
        ListNode curr = head.next, pre = head;
        while (curr != null && curr.next != null) {
            // swap curr and curr.next
            pre.next = curr.next;
            curr.next = curr.next.next;
            pre.next.next = curr;
            pre = curr;
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
        n1 = swapNear(n1);
        System.out.println(n1);
    }

}
