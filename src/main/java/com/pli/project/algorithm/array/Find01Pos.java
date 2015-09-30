package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2015/9/28.
 */
public class Find01Pos {

    public static int findKthRow(int[][] mat){
        if(mat==null||mat.length==0||mat[0]==null||mat[0].length != mat.length){
            return -1;
        }
        int res = -1;
        int row = 0;
        while(row < mat.length) {
            int col = row + 1;
            while(col < mat.length && mat[row][col]==0){
                col++;
            }
            if(col == mat.length){
                return validate(mat, row) ? row : -1;
            }
            else {
                row = col;
            }
        }
        return validate(mat, row) ? row : -1;
    }

    private static boolean validate(int[][] mat, int row) {
        for(int i=0; i<mat.length; i++) {
            if(i==row){
                continue;
            }
            if(mat[row][i]==1|| mat[i][row]==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arr2[][] = {
                {0, 1, 1, 0, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 1, 1, 0, 0},
                {1, 1, 1, 1, 0}
        };
        int arr3[][] = {
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 0, 0},
                {1, 1, 1, 1, 0}
        };
        int arr4[][] = {
                {1, 0, 0, 0},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {1, 1, 1, 0}
        };
        int arr[][] = {
                {0, 1, 0, 1, 0},
                {0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
        };
        int res = findKthRow(arr3);
        System.out.println(res);
    }

}
