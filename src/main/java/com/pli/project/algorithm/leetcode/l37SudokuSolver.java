package com.pli.project.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lipeng on 2016/9/10.
 * https://leetcode.com/problems/sudoku-solver/
 * DFS solves sudoku problem.
 */
public class l37SudokuSolver {

    public void solveSudoku(char[][] board) {
        Set[] colSet = new Set[board.length], rowSet = new Set[board[0].length];
        Set[][] matrixSet = new Set[board.length][board[0].length];
        for (int i = 0; i < 9; i++) {
            colSet[i] = new HashSet<>();
            rowSet[i] = new HashSet<>();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrixSet[i][j] = new HashSet<>();
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                colSet[j].add(board[i][j] - '0');
                rowSet[i].add(board[i][j] - '0');
                matrixSet[i / 3][j / 3].add(board[i][j] - '0');
            }
        }
        dfs(board, 0, 0, colSet, rowSet, matrixSet);
    }

    private boolean dfs(char[][] board, int i, int j, Set[] colSet, Set[] rowSet, Set[][] matrixSet) {
        if (i == 9 && j == 0) {
            return true;
        }
        if (board[i][j] != '.') {
            return j == 8 ? dfs(board, i + 1, 0, colSet, rowSet, matrixSet) : dfs(board, i, j + 1, colSet, rowSet, matrixSet);
        }
        for (int val = 1; val <= 9; val++) {
            if (colSet[j].contains(val) || rowSet[i].contains(val) || matrixSet[i / 3][j / 3].contains(val)) {
                continue;
            }
            board[i][j] = (char)('0' + val);
            colSet[j].add(val);
            rowSet[i].add(val);
            matrixSet[i / 3][j / 3].add(val);
            boolean currAns = (j == 8) ? dfs(board, i + 1, 0, colSet, rowSet, matrixSet) :
                    dfs(board, i, j + 1, colSet, rowSet, matrixSet);
            if (currAns) {
                return true;
            }
            board[i][j] = '.';
            rowSet[i].remove(val);
            colSet[j].remove(val);
            matrixSet[i / 3][j / 3].remove(val);
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        l37SudokuSolver l = new l37SudokuSolver();
        l.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }
}
