package com.pli.project.algorithm.ms;

/**
 * Created by lipeng on 2016/3/17.
 */
public class NumberOfIsland {

    public int numIslands(char[][] grid) {
        int[] ans = new int[1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dfs(grid, i, j, ans);
            }
        }
        return ans[0];
    }

    private void dfs(char[][] grid, int i, int j, int[] ans) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        ans[0]++;
        grid[i][j] = '0';
        dfs(grid, i - 1, j, ans);
        dfs(grid, i + 1, j, ans);
        dfs(grid, i, j - 1, ans);
        dfs(grid, i, j + 1, ans);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1'}
        };
        NumberOfIsland island = new NumberOfIsland();
        System.out.println(island.numIslands(grid));
    }


}
