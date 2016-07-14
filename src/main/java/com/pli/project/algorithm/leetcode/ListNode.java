package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/7/13.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    public String toString() {
        if (next == null) {
            return String.valueOf(val);
        }
        else {
            return String.valueOf(val) + "->" + next;
        }
    }
}