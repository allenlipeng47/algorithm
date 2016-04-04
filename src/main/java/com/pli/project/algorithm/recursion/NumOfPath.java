package com.pli.project.algorithm.recursion;

/**
 * Created by pli on 1/21/2016.
 */
public class NumOfPath {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int[] ans = new int[1];
        obstacleGrid[0][0] = 1;
        dfs(obstacleGrid, 0, 0, ans);
        return ans[0];

    }

    public static void dfs(int[][] obstacleGrid, int x, int y, int[] ans) {
        if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
            ans[0]++;
            return;
        }
        if (x - 1 >= 0 && obstacleGrid[x - 1][y] == 0) {
            obstacleGrid[x - 1][y] = 1;
            dfs(obstacleGrid, x - 1, y,  ans);
            obstacleGrid[x - 1][y] = 0;
        }
        if (x + 1 < obstacleGrid.length && obstacleGrid[x + 1][y] == 0) {
            obstacleGrid[x + 1][y] = 1;
            dfs(obstacleGrid, x + 1, y, ans);
            obstacleGrid[x + 1][y] = 0;
        }
        if (y - 1 >= 0 && obstacleGrid[x][y - 1] == 0) {
            obstacleGrid[x][y - 1] = 1;
            dfs(obstacleGrid, x, y - 1, ans);
            obstacleGrid[x][y - 1] = 0;
        }
        if (y + 1 < obstacleGrid[0].length && obstacleGrid[x][y + 1] == 0) {
            obstacleGrid[x][y + 1] = 1;
            dfs(obstacleGrid, x, y + 1, ans);
            obstacleGrid[x][y + 1] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] obstacle= {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(obstacle));
    }





}
