package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.leetcode.ListNode;
import org.junit.Test;

/**
 * Created by lipeng on 2016/8/14.
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfTwoLLTest {

    @Test
    public void test1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        IntersectionOfTwoLL i = new IntersectionOfTwoLL();
        assert i.getIntersectionNode(l1, null) == null;
    }

}
