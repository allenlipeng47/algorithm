package com.pli.project.algorithm.greedy;

/**
 * Created by lipeng on 2016/1/29.
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1, n = matrix.length;
        while (i < n && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j--;
            }
            else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] arr =
//                {
//        {
//            1, 4, 7, 11, 15
//        },
//        {
//            2, 5, 8, 12, 19
//        },
//        {
//            3, 6, 9, 16, 22
//        },
//        {
//            10, 13, 14, 17, 24
//        },
//        {
//            18, 21, 23, 26, 30
//        }
//    };
        int[][] arr = {{-5}};
        System.out.println(searchMatrix(arr, -5));
    }

}
