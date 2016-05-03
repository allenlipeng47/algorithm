package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2016/5/2.
 * Given an array and target. Partition array into left part less than target, right part equal to or greater than target.
 * In O(n) time.
 */
public class TwoWayPartition {

    public static void twoWayPartition(int[] arr, int target) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = -1, j = 0; j < arr.length; j++) {
            if (arr[j] < target) {
                int tmp = arr[i + 1];
                arr[i + 1] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
    }

}
