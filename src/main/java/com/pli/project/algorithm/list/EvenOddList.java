package com.pli.project.algorithm.list;

/**
 * Created by lipeng on 2016/1/16.
 */
public class EvenOddList {

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

    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode odd = head, even = head.next, curr = head.next.next;   // initial odd, even and curr position
        while (curr != null) {
            // swap odd.next and curr. Put odd number to front
            even.next = curr.next;
            curr.next = odd.next;
            odd.next = curr;
            odd = curr;
            if(even.next == null)
                break;
            // move even list
            even = even.next;
            curr = even.next;
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
        n1 = oddEvenList(n1);
        System.out.println(n1);
    }


}
