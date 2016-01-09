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
        nodes = new Node[numOfNode + 1];
    }

    private void build(int v, int from, int to) {
        Node node = nodes[v];
        if(contain(from, to, node.from, node.to)) {
            node.sum = num[element(v)] * node.size;
            node.min = num[element(v)];
        }
        if(node.size == 1)
            return;
        if(overlap(from, to, node.from, node.to)) {
            int left = v * 2, right = left + 1;
            build(left, from, to);
            build(right, from, to);
            node.sum = nodes[left].sum + nodes[right].sum;
            node.min = Math.min(nodes[left].min, nodes[right].min);
        }
    }

    public int querySum(int i, int j) {

        return -1;
    }

    public int querySum(int v, int from, int to) {
        Node node = nodes[v];
        int sum = 0;
        if(contain(from, to, node.from, node.to)) {
//            sum =
        }
        return -1;
    }

    // propagate the val to
    private void propagate(int v, int val) {
        Node node = nodes[v];
        if(node.size == 1)
            return;
        int left = v * 2, right = left + 1;
        nodes[left].pendingVal = nodes[left].pendingVal == null ? val : nodes[left].pendingVal + val;
        nodes[right].pendingVal = nodes[right].pendingVal == null ? val : nodes[right].pendingVal + val;
    }

    private void update(int v) {
        Node node = nodes[v];
        if(node.pendingVal != null) {
            node.min += node.pendingVal;
            node.sum += node.pendingVal * node.size;
            propagate(v, node.pendingVal);
            node.pendingVal = null;
        }
    }

    private int element(int v) {
        return num[v - 1];
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
        int value, from, to, size, min, sum;
        Integer pendingVal;

        public Node(int value, int from, int to) {
            this.value = value; this.from = from; this.to = to; this.size = from - to + 1;
        }
    }


    public static void main(String[] args) {
        int from1 = -4, to1 = 4, from2 = 10, to2 = 13;
        System.out.println(overlap(from1, to1, from2, to2));
    }

}
