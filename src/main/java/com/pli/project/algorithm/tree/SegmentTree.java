package com.pli.project.algorithm.tree;

import com.pli.project.algorithm.graph.Dijkstra;

/**
 * Created by lipeng on 2016/1/8.
 * Implemented by lazy propagation
 */
public class SegmentTree {

    Node[] nodes;
    int[] num;

    public SegmentTree(int[] num) {
        this.num = num;
        int height = (int)(Math.log(num.length - 1) / Math.log(2)) + 1,  numOfNode;
        if(height == 0)
            numOfNode = 1;
        else
            numOfNode = (int)Math.pow(2, height + 1);
        nodes = new Node[numOfNode];
    }

    private void build(int v, int from, int to) {

    }

    // return true if range1 contains range2. Assume from1 <= to1, from2 <= to2
    public static boolean contain(int from1, int to1, int from2, int to2) {
        if(from1 <= from2 && to2 <= to1)
            return true;
        else
            return false;
    }

    public static boolean overlap(int from1, int to1, int from2, int to2) {
        if(from1 <= from2 && to1 >= from2
                || from2 <= from1 && to2 >= from1)
            return true;
        else
            return false;
    }




    private static class Node {
        int value, from, to;
        Integer pendingVal;

        public Node(int value, int from, int to) {
            this.value = value; this.from = from; this.to = to;
        }
    }


    public static void main(String[] args) {
        int from1 = -4, to1 = 4, from2 = 10, to2 = 13;
        System.out.println(overlap(from1, to1, from2, to2));
    }

}
