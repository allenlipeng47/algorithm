package com.pli.project.algorithm.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by lipeng on 2016/3/4.
 * Use heap to merge the array.
 * The idea is to create a class implements Comparable. Then put it in heap.
 */
public class MergeKSortedArray {

    static class SortedArray implements Comparable<SortedArray>{
        int pos;
        int[] arr;
        public SortedArray(int[] arr) {
            this.arr = arr;
            pos = 0;
        }

        public int compareTo(SortedArray that) {
            return this.arr[this.pos] - that.arr[that.pos];
        }
    }

    public static int[] sortKArray(int[][] arrs) {
        int len = 0;
        PriorityQueue<SortedArray> heap = new PriorityQueue<>();
        for (int[] arr : arrs) {
            heap.add(new SortedArray(arr));
            len += arr.length;
        }
        int[] ans = new int[len];
        for (int pos = 0; !heap.isEmpty(); pos++) {
            SortedArray curr = heap.poll();
            ans[pos] = curr.arr[curr.pos];
            if (++curr.pos < curr.arr.length) {
                heap.add(curr);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arrs = {
                {1, 3, 5},
                {2, 4, 6},
                {0, 7, 9}
        };
        int[] ans = sortKArray(arrs);
        System.out.println(Arrays.toString(ans));
    }
}
