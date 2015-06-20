package com.pli.project.algorithm.numbertheory;

/**
 * Created by lipeng on 2015/5/25.
 */
public class PerfectSquare {

    public static int num_squares(int n){
        int[] table = new int[n+1];
        int max = (int)Math.floor(Math.sqrt(n));
        int squared;

        for (int i=0; i<=n; i++){
            table[i] = i;
        }
        for (int i=2; i<=max; i++){
            squared = (int)Math.pow(i,2);
            for (int j=0; j<=n; j++){
                if (squared <= j)
                    table[j] = Math.min(table[j], table[j - squared] + 1);
            }
        }
        return table[n];
    }

    public static void main(String[] args) {
        int result = num_squares(13);
        System.out.println(result);
    }
}







