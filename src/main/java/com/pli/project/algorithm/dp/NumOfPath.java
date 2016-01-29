package com.pli.project.algorithm.dp;

/**
 * Created by lipeng on 2016/1/21.
 * http://www.lintcode.com/en/problem/unique-paths-ii/
 */
public class NumOfPath {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] matrix = new int[n][m];
        matrix[0][0] = 1;
        for (int i = 1; i < n; i++)
            matrix[i][0] = obstacleGrid[i][0] == 0 ? matrix[i - 1][0] : 0;
        for (int i = 1; i < m; i++)
            matrix[0][i] = obstacleGrid[0][i] == 0 ? matrix[0][i - 1] : 0;
        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++)
                matrix[i][j] = obstacleGrid[i][j] == 0 ? (matrix[i - 1][j] + matrix[i][j - 1]) : 0;
        return matrix[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0,0,0},
                {0,0,1},
                {0,0,0},
                {0,0,0}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

}
