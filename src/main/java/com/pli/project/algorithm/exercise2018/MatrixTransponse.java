package com.pli.project.algorithm.exercise2018;

import java.util.Arrays;

public class MatrixTransponse {

    public static int[][] transposeMatrix(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0) {
            return matrix;
        }
        for (int delta  = 1; delta < matrix.length; delta++) {
            for (int i = 0; i < matrix.length - delta; i++) {
                int tmp = matrix[i][i + delta];
                matrix[i][i + delta] = matrix[i + delta][i];
                matrix[i + delta][i] = tmp;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        System.out.println(Arrays.deepToString(transposeMatrix(matrix)));
    }
}
