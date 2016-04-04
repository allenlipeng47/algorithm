package com.pli.project.algorithm.array;

import java.util.*;

/**
 * Created by lipeng on 2016/1/21.
 */
public class LongestIncreasingPath {

    public static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;
        int n = matrix.length, m = matrix[0].length, count = m * n, ans = 0;
        while (count > 0) {
            HashSet<Point> remove = new HashSet<Point>();
            // each round, remove the peak number.
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == Integer.MIN_VALUE)
                        continue;
                    boolean up = (i == 0 || matrix[i][j] >= matrix[i - 1][j]);
                    boolean bottom = (i == n - 1 || matrix[i][j] >= matrix[i + 1][j]);
                    boolean left = (j == 0 || matrix[i][j] >= matrix[i][j - 1]);
                    boolean right = (j == m - 1 || matrix[i][j] >= matrix[i][j + 1]);
                    if (up && bottom && left && right)
                        remove.add(new Point(i, j));
                }
            }
            for (Point point : remove) {
                matrix[point.x][point.y] = Integer.MIN_VALUE;
                count--;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[][]nums = {
//        {9,9,4},
//        {6,6,8},
//        {2,1,1}
//        };
//        int[][] nums = {
//                {3, 4, 5},
//                {3, 2, 6},
//                {2, 2, 1}
//        };
        int[][] nums = {};
        System.out.println(longestIncreasingPath(nums));
    }
}
