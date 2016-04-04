package com.pli.project.algorithm.list;

/**
 * Created by lipeng on 2016/1/31.
 */
public class IsPalindrome {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        public String toString() {
            if (this.next == null) {
                return String.valueOf(val);
            }
            return String.valueOf(val) + ", " + next;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tail = reverse(slow.next);
        while (tail != null) {  // compare head and tail. Move from two side to middle
            if (tail.val != head.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(2);
//        ListNode l4 = new ListNode(1);
//        ListNode l5 = new ListNode(1);
        l1.next = l2;
        System.out.println(isPalindrome(l1));
    }

    public static void test2() {
        System.out.println(isPalindrome(null));
    }

}
