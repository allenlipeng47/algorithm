package com.pli.project.algorithm.ms;

/**
 * Created by lipeng on 2016/3/19.
 */
public class CopyListWithRandomPointer {

    static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
        public String toString() {
            if (next != null) {
                return String.valueOf(label);
            }
            else {
                return label + "->";
            }
        }
    };

     public static RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode copy = new RandomListNode(curr.label);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        RandomListNode ans = null;
        if (head != null) {
            ans = head.next;
        }
        curr = head;
        while (curr != null) {
            RandomListNode copy = curr.next;
            curr.next = copy.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            curr = curr.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer copy = new CopyListWithRandomPointer();
        RandomListNode l1 = new RandomListNode(1);
        RandomListNode l2 = new RandomListNode(2);
        l1.next = l2;
        RandomListNode ans = copyRandomList(l1);
        System.out.println();
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
