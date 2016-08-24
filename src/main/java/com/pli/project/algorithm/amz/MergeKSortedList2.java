package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.leetcode.ListNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by lipeng on 2016/8/23.
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedList2 {

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((p1, p2) -> p1.val - p2.val);
        ListNode dummyHead = new ListNode(-1), curr = dummyHead;
        Arrays.stream(lists).filter(p -> p != null).forEach(p -> queue.add(p));
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            curr.next = node;
            curr = node;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        curr.next = null;
        return dummyHead.next;
    }

}
