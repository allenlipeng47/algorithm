package com.pli.project.algorithm.array;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/7/31.
 * This one is a sub problem from https://leetcode.com/problems/recover-binary-search-tree/
 * Given a sorted array, but 2 elements are swapped. Restore this sorted array.
 */
public class RestoreSortedArray {

    public static void recoverArray(int[] arr) {
        Integer first = null, second = null;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                if (first == null) {
                    first = i;
                }
                second = i + 1;
            }
        }
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 4, 5, 6, 2};
        recoverArray(arr);
        System.out.println(Arrays.toString(arr));
    }


}
