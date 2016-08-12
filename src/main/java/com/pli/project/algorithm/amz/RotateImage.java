package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/11.
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1;
        while (top < bottom) {
            for (int i = 0; i < matrix[0].length; i++) {
                int tmp = matrix[top][i];
                matrix[top][i] = matrix[bottom][i];
                matrix[bottom][i] = tmp;
            }
            top++;
            bottom--;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

}
