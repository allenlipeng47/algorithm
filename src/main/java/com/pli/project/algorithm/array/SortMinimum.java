package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2016/3/4.
 * Practice. An unsorted array, find the minimum length that we sort it, then whole array is sorted.
 */
public class SortMinimum {

    public static int getMinRange(int[] arr) {
        int leftMost = 1;
        for (int i = 1; i < arr.length && arr[i] >= arr[i - 1] ; i++);
        int rightMost = arr.length - 2;
        for (; rightMost > 0 && arr[rightMost] >= arr[rightMost + 1]; rightMost--);
        if (leftMost >= rightMost) {
            return 0;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int left = findLeft(arr, 0, leftMost - 1, min);
        int right = findRight(arr, rightMost + 1, arr.length - 1, max);
        return right - left + 1;
    }

    // find the first element i between left and right, where arr[i - 1] <= val, arr[i] > val
    public static int findLeft(int[] arr, int left, int right, int value) {
        if (value < arr[left]) {
            return left;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid - 1] <= value) {
                if (arr[mid] > value) {
                    return mid;
                }
                else {
                    left = mid + 1;
                }
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int findRight(int[] arr, int left, int right, int value) {
        if (value >= arr[right]) {
            return right;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (value <= arr[mid + 1]) {
                if (value > arr[mid]) {
                    return mid;
                }
                else {
                    right = mid;
                }
            }
            else {
                left = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 4, 5, 10, 9, 12, 13, 14, 15};
        System.out.println(getMinRange(arr));
    }
}
