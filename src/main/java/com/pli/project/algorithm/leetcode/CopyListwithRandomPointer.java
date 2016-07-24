package com.pli.project.algorithm.leetcode;

import com.pli.project.algorithm.ms.CopyListWithRandomPointer;

import java.util.HashMap;

/**
 * Created by lipeng on 2016/7/23.
 */
public class CopyListwithRandomPointer {

    static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };

    public static RandomListNode copyRandomList(RandomListNode node) {
        HashMap<RandomListNode, RandomListNode> hm = new HashMap<>();
        RandomListNode curr = node;
        while (curr != null) {
            hm.put(curr, new RandomListNode(curr.label));
            curr = curr.next;
        }
        curr = node;
        while (curr != null) {
            hm.get(curr).next = hm.get(curr.next);
            hm.get(curr).random = hm.get(curr.random);
            curr = curr.next;
        }
        return hm.get(node);
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        CopyListWithRandomPointer copy = new CopyListWithRandomPointer();
        RandomListNode l1 = new RandomListNode(1);
        RandomListNode l2 = new RandomListNode(2);
        RandomListNode l3 = new RandomListNode(3);
        l1.next = l2; l2.next = l3;
        l1.random = l3;
        l2.random = l1;
        l3.random = l2;
        RandomListNode ans = copyRandomList(l1);
        System.out.println();
    }
}
