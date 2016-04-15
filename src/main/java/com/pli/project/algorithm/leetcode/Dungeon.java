package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/4/14.
 */
public class Dungeon {

    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][m] = Integer.MAX_VALUE;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[n][j] = Integer.MAX_VALUE;
        }
        dp[n - 1][m] = dp[n][m - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int need = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = need <= 0 ? 1 : need;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] dungeon = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        Dungeon d = new Dungeon();
        int ans = d.calculateMinimumHP(dungeon);
        System.out.println(ans);
    }
}
