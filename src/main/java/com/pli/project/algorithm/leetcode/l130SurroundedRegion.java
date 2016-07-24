package com.pli.project.algorithm.leetcode;

import java.util.function.BinaryOperator;

/**
 * Created by lipeng on 2016/7/23.
 * https://leetcode.com/problems/surrounded-regions/
 */
public class l130SurroundedRegion {

    public static void solve(char[][] board) {
        if (board == null || board.length <= 0 || board[0] == null || board[0].length <= 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        // scan left and right column
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0);
            if (board[i][n - 1] == 'O')
                dfs(board, i, n - 1);
        }
        // scan top and bottom row
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O')
                dfs(board, 0, i);
            if (board[m - 1][i] == 'O')
                dfs(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'E') {
                    board[i][j] = 'O';
                }
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(char[][] board, int i, int j) {
        board[i][j] = 'E';
        if (i > 1 && board[i - 1][j] =='O')
            dfs(board, i - 1, j);
        if (i < board.length - 2 && board[i + 1][j] == 'O')
            dfs(board, i + 1, j);
        if (j > 1 && board[i][j - 1] == 'O')
            dfs(board, i, j - 1);
        if (j < board[0].length - 2 && board[i][j + 1] == 'O')
            dfs(board, i, j + 1);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
//        char[][] board = {};
        solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
