package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/11.
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class SearchTwoDMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (target < matrix[i][j]) {
                j--;
            }
            else {
                i++;
            }
        }
        return false;
    }


}
