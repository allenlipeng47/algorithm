package com.pli.project.algorithm.amz;

import java.util.HashMap;

/**
 * Created by lipeng on 2016/8/11.
 */
public class CopyListWithRandomPointer {

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };

    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> hm = new HashMap<>();
        return copyHelper(head, hm);
    }

    public RandomListNode copyHelper(RandomListNode head, HashMap<RandomListNode, RandomListNode> hm) {
        if (head == null) {
            return null;
        }
        if (hm.containsKey(head)) {
            return hm.get(head);
        }
        RandomListNode node = new RandomListNode(head.label);
        hm.put(head, node);
        node.next = copyHelper(head.next, hm);
        node.random = copyHelper(head.random, hm);
        return node;
    }


}
