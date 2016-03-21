package com.pli.project.algorithm.ms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/3/19.
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length < 1) {
            return ans;
        }
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            // from left to right
            int i = left;
            while (i <= right && left <= right && top <= bottom) {
                ans.add(matrix[top][i++]);
            }
            top++;
            i = top;
            while (i <= bottom && left <= right && top <= bottom) {
                ans.add(matrix[i++][right]);
            }
            right--;
            i = right;
            while (i >= left && left <= right && top <= bottom) {
                ans.add(matrix[bottom][i--]);
            }
            bottom--;
            i = bottom;
            while (i >= top && left <= right && top <= bottom) {
                ans.add(matrix[i--][left]);
            }
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        SpiralMatrix s = new SpiralMatrix();
        List<Integer> ans = s.spiralOrder(matrix);
        System.out.println(ans);
    }

}
