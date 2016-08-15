package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.leetcode.ListNode;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * Created by lipeng on 2016/8/15.
 */
public class MergeKSortedListTest {

    @Test
    public void test1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l3.next = l4;
        l5.next = l6;
        ListNode[] nodes = new ListNode[]{l1, l3, l5};
        MergeKSortedList m = new MergeKSortedList();
        System.out.println(m.mergeKLists(nodes));
    }
}
