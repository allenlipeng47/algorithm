package com.pli.project.algorithm.practice;

import com.pli.project.algorithm.leetcode.ListNode;
import org.junit.Test;

/**
 * Created by lipeng on 2016/8/10.
 */
public class AddTwoNumbersTest {



    @Test
    public void test1() {
        AddTwoNumbers a = new AddTwoNumbers();
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l11.next = l12; l12.next = l13;
        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22; l22.next = l23;
        ListNode l = a.addTwoNumbers(l11, l21);
        assert l.val == 7 && l.next.val == 0 && l.next.next.val == 8;
        System.out.println(l);
    }
}


