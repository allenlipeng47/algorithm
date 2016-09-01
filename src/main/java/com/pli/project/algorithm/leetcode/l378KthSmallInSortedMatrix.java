package com.pli.project.algorithm.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by lipeng on 2016/8/31.
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class l378KthSmallInSortedMatrix {

    static class Idx {
        public int row;
        public int col;
        public Idx(int row) {
            this.row = row;
            col = 0;
        }
    }

    public static int kthSmallest(int[][] matrix, int k) {
        Queue<Idx> queue = new PriorityQueue<>((idx1, idx2) -> matrix[idx1.row][idx1.col] - matrix[idx2.row][idx2.col]);
        for (int i = 0; i < matrix.length; i++) {
            queue.add(new Idx(i));
        }
        Idx idx = null;
        for (int i = 0; i < k; i++) {
            idx = queue.poll();
            if (++idx.col < matrix[0].length) {
                queue.add(idx);
            }
        }
        return matrix[idx.row][idx.col - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        System.out.println(kthSmallest(matrix, 5));

    }

}
