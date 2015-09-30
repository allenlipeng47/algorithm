package com.pli.project.algorithm.dp;

/**
 * Created by lipeng on 2015/9/29.
 */
public class FindPalindromeInString {

    public static int longestPotentialPalindrome(String str) {
        if(str==null||str.length()==0){
            return -1;
        }
        int[][] store = new int[str.length()][str.length()];
        store[0][0] = str.charAt(0)==str.charAt(str.length() - 1) ? 1 : 0;
        // initial first row
        for(int i=1; i<str.length(); i++) {
            if(store[0][i-1]==1 || str.charAt(i)==str.charAt(str.length() - 1)) {
                store[0][i] = 1;
            }
            else {
                store[0][i] = 0;
            }
            if(store[i-1][0]==1 || str.charAt(str.length() - 1 - i)==str.charAt(0)) {
                store[i][0] = 1;
            }
            else {
                store[i][0] = 0;
            }
        }
        for(int i=1; i<str.length(); i++) {
            for(int j=1; j<str.length(); j++) {
                int topLeft = store[i-1][j];
                if(str.charAt(str.length()-1-i)==str.charAt(j)) {
                    topLeft++;
                }
                store[i][j] = Math.max(Math.max(store[i-1][j], store[i][j-1]), topLeft);
            }
        }
        return store[str.length()-1][str.length()-1];
    }

    public static void main(String[] args) {
        String str = "sfinished";
        int result = longestPotentialPalindrome(str);
        System.out.println(result);
    }

}
