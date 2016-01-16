package com.pli.project.algorithm.array;

/**
 * Created by pli on 1/15/2016.
 * Given a 2d matrix, only 0, 1 are in the matrix. All 1 elements are connected. Print the minimum rectangle which can cover the 1 elements.
 * Solution: 1st find the first 1. Then use binary search to search the boundaries.
 */
public class FindSquare1 {


    public static void print1Edge(int[][] arr) {
        // find the first 1
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                if(arr[i][j] == 1) {
                    System.out.println("left: " + findLeft(arr, j));
                    System.out.println("right: " + findRight(arr, j));
                    System.out.println("top: " + findTop(arr, i));
                    System.out.println("bottom: " + findBottom(arr, i));
                    return;
                }
    }

    public static int findTop(int[][] arr, int bottom) {
        int top = 0;
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            if(rowHas1(arr, mid) && (mid <= 0 || !rowHas1(arr, mid - 1)))
                return mid;
            else if(rowHas1(arr, mid))
                bottom = mid - 1;
            else
                top = mid + 1;
        }
        return -1;
    }

    public static int findBottom(int[][] arr, int top) {
        int bottom = arr.length - 1;
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            if(rowHas1(arr, mid) && (mid >= arr.length - 1 || !rowHas1(arr, mid + 1)))
                return mid;
            else if(rowHas1(arr, mid))
                top = mid + 1;
            else
                bottom = mid - 1;
        }
        return -1;
    }

    public static int findLeft(int[][] arr, int right) {
        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(colHas1(arr, mid) && (mid <= 0 || !colHas1(arr, mid - 1)))
                return mid;
            else if(colHas1(arr, mid))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    public static int findRight(int[][] arr, int left) {
        int right = arr[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(colHas1(arr, mid) && (mid >= arr[0].length - 1 || !colHas1(arr, mid + 1)))
                return mid;
            else if(colHas1(arr, mid))
                left = mid + 1;
            else
                right = mid - 1;

        }
        return -1;
    }

    public static boolean rowHas1(int[][] arr, int row) {
        for(int i = 0; i < arr[0].length; i++)
            if(arr[row][i] == 1)
                return true;
        return false;
    }

    public static boolean colHas1(int[][] arr, int col) {
        for(int i = 0; i < arr.length; i++)
            if(arr[i][col] == 1)
                return true;
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 1},
                {0, 0, 0, 0}
        };
        print1Edge(arr);
    }

}
