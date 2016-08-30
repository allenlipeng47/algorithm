package com.pli.project.algorithm.leetcode;

import java.util.Random;

/**
 * Created by lipeng on 2016/8/28.
 * https://leetcode.com/problems/linked-list-random-node/
 * Elements are 0, 1, 2, 3. When we have result of [0, 1, 2] and want to get result for [0, 1, 2, 3],
 * get a random(4), possible value should be [0, 1, 2, 3], if the random value is equal to 3, the return 3.
 * Else keep the same.
 */
public class l382LinkedListRandomNode {

    ListNode head;
    Random random;

    public l382LinkedListRandomNode(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        int result = 0, i = 1;
        ListNode curr = head;
        while (curr != null) {
            int r = random.nextInt(i);
            if (r == i - 1) {
                result = curr.val;
            }
            curr = curr.next;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2; l2.next = l3; l3.next = l4;
        l382LinkedListRandomNode l = new l382LinkedListRandomNode(l1);
        System.out.println(l.getRandom());
    }

}
