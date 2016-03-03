package com.pli.project.algorithm.array;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by lipeng on 2015/12/12.
 * Given an array of intervals, merge them to see how many individual intervals totally has
 */
public class KthLargestElement {

    public static int getKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : arr) {
            maxHeap.add(i);
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = maxHeap.poll();
        }
        return ans;
    }

    public static int getKthLargest2(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, arr.length - k);
    }

    public static int quickSelect(int[] arr, int left, int right, int k) {
        int pivot = arr[left];
        int lo = left, hi = right;
        while (lo < hi) {
            while (lo < hi && pivot <= arr[hi]) {
                hi--;
            }
            arr[lo] = arr[hi];
            while (lo < hi && pivot >= arr[lo]) {
                lo++;
            }
            arr[hi] = arr[lo];
        }
        arr[hi] = pivot;
        if (hi == k) {
            return pivot;
        }
        else if (hi > k) {
            return quickSelect(arr, left, hi - 1, k);
        }
        else {
            return quickSelect(arr, hi + 1, right, k);
        }
    }

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49};
        System.out.println(getKthLargest2(arr, 3));
    }


}
