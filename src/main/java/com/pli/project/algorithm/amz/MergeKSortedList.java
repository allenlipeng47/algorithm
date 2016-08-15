package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.leetcode.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lipeng on 2016/8/15.
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            queue.add(node);
        }
        ListNode dummyHead = new ListNode(-1), curr = dummyHead;
        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
            if (curr.next != null) {
                queue.add(curr.next);
            }
        }
        return dummyHead.next;
    }

}
