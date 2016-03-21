package com.pli.project.algorithm.ms;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/3/19.
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        for (int delta = 1; delta < matrix.length; delta++) {
            for (int i = 0; i < matrix.length - delta; i++) {
                int tmp = matrix[i][i + delta];
                matrix[i][i + delta] = matrix[i + delta][i];
                matrix[i + delta][i] = tmp;
            }
        }
        for (int i = 0; i <= matrix.length / 2 - 1; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[j][matrix.length - i - 1];
                matrix[j][matrix.length - i - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        RotateImage r = new RotateImage();
        r.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }


}
