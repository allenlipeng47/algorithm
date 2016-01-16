package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2016/1/10.
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class RangeSumQuery2D {

    private int[][] sumMatrix;

    public RangeSumQuery2D(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        sumMatrix = new int[row][col];
        sumMatrix[0][0] = matrix[0][0];
        for(int i = 1; i < row; i++)
            sumMatrix[i][0] = sumMatrix[i - 1][0] + matrix[i][0];
        for(int i = 1; i < col; i++)
            sumMatrix[0][i] = sumMatrix[0][i - 1] + matrix[0][i];
        for(int i = 1; i < row; i++)
            for (int j = 1; j < col; j++)
                sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1] + matrix[i][j];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMatrix[row2][col2]
                - (col1 <= 0 ? 0 : sumMatrix[row2][col1 - 1])
                - (row1 <= 0 ? 0 : sumMatrix[row1 - 1][col2])
                + (row1 <= 0 || col1 <= 0 ? 0 : sumMatrix[row1 - 1][col1 - 1]);
    }

    public static void main(String[] args) {
        int[][] matrix = {
        {3, 0, 1, 4, 2},
        {5, 6, 3, 2, 1},
        {1, 2, 0, 1, 5},
        {4, 1, 0, 1, 7},
        {1, 0, 3, 0, 5}
    };
        RangeSumQuery2D m = new RangeSumQuery2D(matrix);
        System.out.println(m.sumRegion(2, 1, 4, 3));
        System.out.println(m.sumRegion(1, 1, 2, 2));
        System.out.println(m.sumRegion(1, 2, 2, 4));
        System.out.println(m.sumRegion(2, 0, 2, 0));
    }
}
