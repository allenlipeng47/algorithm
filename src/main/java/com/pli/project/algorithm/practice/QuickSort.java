package com.pli.project.algorithm.practice;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/5/2.
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        partition(arr, 0, arr.length - 1);
    }

    public static void partition(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int i = lo, j = hi, pivot = arr[lo];
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        partition(arr, lo, i - 1);
        partition(arr, i + 1, hi);
    }



    public static void main(String[] args) {
        int[] arr = {2, 1, 1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
