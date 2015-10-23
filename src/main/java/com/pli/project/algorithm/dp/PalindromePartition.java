package com.pli.project.algorithm.dp;

/**
 * Created by lipeng on 2015/10/21.
 * Given a string, we try to split the string to each sub-string. Each sub-string needs to be palindrome.
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 */
public class PalindromePartition {

    public static int getMinPalindromePartition(String s) {
        char[] chs = s.toCharArray();
        int[][] arr = new int[chs.length][chs.length];
        for(int i=0; i<chs.length; i++) {
            arr[i][i] = 1;
        }
        for(int gap=1; gap<chs.length; gap++) {
            for(int i=0; i<chs.length-gap; i++) {
                if(arr[i+1][i+gap-1]<=1&&chs[i]==chs[i+gap]) {
                    arr[i][i+gap] = 1;
                }
                else {
                    int minPartition = Integer.MAX_VALUE;
                    for(int k=0; k<gap; k++) {
                        minPartition = Math.min(minPartition, arr[i][i+k]+arr[i+k+1][i+gap]);
                    }
                    arr[i][i+gap] = minPartition;
                }
            }
        }
        return arr[0][chs.length-1];
    }

    public static void main(String[] args) {
        String str = "abacbdbc";
        System.out.println(getMinPalindromePartition(str));
    }

}