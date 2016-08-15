package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.leetcode.ListNode;
import org.junit.Test;

/**
 * Created by lipeng on 2016/8/14.
 */
public class PalindromeLinkedListTest {

    @Test
    public void test1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2; l2.next = l3; l3.next = l4;
        PalindromeLinkedList p = new PalindromeLinkedList();
        ListNode reverse = p.reverse(l1);
        assert reverse.val == 4;
        assert reverse.next.val == 3;
        assert reverse.next.next.val == 2;
        assert reverse.next.next.next.val == 1;
    }

    @Test
    public void test2() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(2);
        ListNode l7 = new ListNode(1);
        l1.next = l2; l2.next = l3; l3.next = l4; l4.next = l5;
        l5.next = l6; l6.next = l7;
        PalindromeLinkedList p = new PalindromeLinkedList();
        assert p.isPalindrome(l1) == true;
    }
}
