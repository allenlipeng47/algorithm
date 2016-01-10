package com.pli.project.algorithm.tree;

/**
 * Created by lipeng on 2016/1/8.
 * Lazy propagation
 */
public class SegmentTree {

    Node[] nodes;
    int[] num;

    public SegmentTree(int[] num) {
        this.num = num;
        // calculate how many nodes does tree need to build segment tree. First calculate tree height, then number of nodes.
        int height = (int)(Math.log(num.length - 1) / Math.log(2)) + 1,  numOfNode;
        if(height == 0)
            numOfNode = 1;
        else
            numOfNode = (int)Math.pow(2, height + 1);
        nodes = new Node[numOfNode + 1];
        build(1, 1, num.length);
    }

    // recursively build segment tree
    private void build(int v, int from, int to) {
        Node node = nodes[v] = new Node(v, from, to);
        if(node.size == 1) {
            node.sum = node.min = element(from);
        }
        else {
            int mid = from + ((to - from) >> 1);
            build(v * 2, from, mid);
            build(v * 2 + 1, mid + 1, to);
            node.sum = nodes[v * 2].sum + nodes[v * 2 + 1].sum;
            node.min = Math.min(nodes[v * 2].min, nodes[v * 2 + 1].min);
        }
    }

    public int querySum(int i, int j) {
        return querySum(1, i + 1, j + 1);
    }

    private int querySum(int v, int from, int to) {
        Node node = nodes[v];
        if(contain(from, to, node.from, node.to)) {
            return node.sum;
        }
        if(node.size == 1)
            return 0;
        if(overlap(from, to, node.from, node.to)) {
            propagate(v, node.pendingVal);
            return querySum(v * 2, from, to) + querySum(v * 2 + 1, from, to);
        }
        return 0;
    }

    public int queryMin(int i, int j) {
        return queryMin(1, i + 1, j + 1);
    }

    private int queryMin(int v, int from, int to) {
        Node node = nodes[v];
        if(contain(from, to, node.from, node.to)) {
            return node.min;
        }
        if(node.size == 1)
            return Integer.MAX_VALUE;
        if(overlap(from, to, node.from, node.to)) {
            propagate(v, node.pendingVal);
            return Math.min(queryMin(v * 2, from, to), queryMin(v * 2 + 1, from, to));
        }
        return Integer.MAX_VALUE;
    }

    // range[from,...,to] add value
    public void update(int from, int to, int value) {
        update(1, from + 1, to + 1, value);
    }

    private void update(int v, int from, int to, int value) {
        Node node = nodes[v];
        if(contain(from, to, node.from, node.to)) { // if range contains node, update node and its pending value
            node.sum += value * node.size;
            node.min += value;
            node.pendingVal = node.pendingVal == null ? value : node.pendingVal + value;
            return;
        }
        if(node.size == 1)  // no matter if range contains node or not, as long as node is leaf, always return.
            return;
        if(overlap(from, to, node.from, node.to)) {
            propagate(v, node.pendingVal);
            update(v * 2, from, to, value);
            update(v * 2 + 1, from, to, value);
            node.sum = nodes[v * 2].sum + nodes[v * 2 + 1].sum;
            node.min = Math.min(nodes[v * 2].min, nodes[v * 2 + 1].min);
        }
    }

    // propagate the pending value to v's children. And update children sum, min
    private void propagate(int v, Integer val) {
        if(val == null)
            return;
        Node left = nodes[v * 2], right = nodes[v * 2 + 1];
        left.pendingVal = left.pendingVal == null ? val : left.pendingVal + val;
        right.pendingVal = right.pendingVal == null ? val : right.pendingVal + val;
        left.sum += left.size * val; left.min += val;
        right.sum += right.size * val; right.min += val;
        nodes[v].pendingVal = null;
    }

    //if Node[v] has pending value, the update its value.
    private void lazyUpdate(int v) {
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

    // return true is range1 overlaps range2. If one contains another one, return true too.
    public static boolean overlap(int from1, int to1, int from2, int to2) {
        if(from1 <= from2 && to1 >= from2
                || from2 <= from1 && to2 >= from1)
            return true;
        else
            return false;
    }

    private static class Node {

        int value;  // value indicates the position in nodes[] array
        int from;   // from and to is the range of node
        int to; // from and to is the range of node
        int size;   // range length of node
        int min;
        int sum;

        /*When pendingVal is null, means no pendingVal. Otherwise it is the pending value.
        Pending value is used to propagate node's children.
        When update pending value, min and sum are both update too. */
        Integer pendingVal;

        public Node(int value, int from, int to) {
            this.value = value;
            this.from = from;
            this.to = to;
            this.size = to - from + 1;
        }
    }

    public static void main(String[] args) {
        test3();
    }

    public static void test4 () {
        int[] num = {1, 2, 3, 4, 5};
        SegmentTree tree = new SegmentTree(num);
        tree.update(0, 2, 1);
        tree.update(0, 2, 1);
        tree.update(1, 1, 1);
        tree.update(3, 4, 1);
        System.out.println(tree.querySum(3, 5));
    }


    public static void test1() {
        int[] num = {1, 2, 3, 4, 5, 6};
        SegmentTree tree = new SegmentTree(num);
        tree.update(2, 5, 1);
        tree.update(3, 5, 1);
        tree.update(0, 5, 1);
        System.out.println(tree.querySum(0, 5));
    }

    public static void test2() {
        int[] num = {1, 2, 3, 4, 5, 6, 7};
        SegmentTree tree = new SegmentTree(num);
        tree.update(0, 3, 3);
        tree.update(0, 3, 1);
        tree.update(0, 0, 2);
        System.out.println(tree.queryMin(0, 6));
    }

    public static void test3() {
        int[] num = {1, 2, 3, 4, 5};
        SegmentTree tree = new SegmentTree(num);
        tree.update(0, 2, 1);
        tree.update(0, 2, 1);
        tree.update(1, 1, 2);
        tree.update(3, 4, 1);
        System.out.println(tree.querySum(2, 3));
        System.out.println(tree.queryMin(0, 4));
    }

}
