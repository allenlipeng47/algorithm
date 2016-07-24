package com.pli.project.algorithm;

/**
 * Created by lipeng on 2016/5/2.
 */
public class TestQuickSelect {

    public static int partition(int[] arr, int lo, int hi) {
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
        return i;
    }

    public static int quickSelect(int[] arr, int k) {
        k = arr.length - k;
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int i = partition(arr, lo, hi);
            if (i < k) {
                lo = i + 1;
            }
            else if (i > k) {
                hi = i - 1;
            }
            else {
                return arr[i];
            }
        }
        return arr[lo];
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 5, 6};
        System.out.println(quickSelect(arr, 1));
    }

}
