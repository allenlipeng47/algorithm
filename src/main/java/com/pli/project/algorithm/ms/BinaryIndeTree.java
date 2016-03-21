package com.pli.project.algorithm.ms;

import com.pli.project.algorithm.tree.BinaryIndexedTree;

/**
 * Created by lipeng on 2016/3/20.
 */
public class BinaryIndeTree {

    int size;
    private int[] arr;

    public BinaryIndeTree(int size) {
        this.size = size;
        arr = new int[size + 1];
    }

    public void increase(int idx, int val) {
        while (idx <= size) {
            arr[idx] += val;
            idx += idx & (-idx);
        }
    }

    public int getSum(int idx) {
        int ans = 0;
        while (idx > 0) {
            ans += arr[idx];
            idx -= idx & (-idx);
        }
        return ans;
    }

    public static void main(String[] args) {
        BinaryIndeTree tree = new BinaryIndeTree(15);
        tree.increase(1, 1);
        tree.increase(2, 2);
        tree.increase(3, 3);
        tree.increase(4, 4);
        tree.increase(5, 5);
        System.out.println(tree.getSum(4));
        System.out.println(tree.getSum(6));
        System.out.println(tree.getSum(7));

    }




}
