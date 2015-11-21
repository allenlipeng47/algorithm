package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2015/11/17.
 */
public class LongestPalindromeStartingLeft {

    public static int longestPalindromeStartingLeft(String str) {
        int left=0, right=str.length()-1;
        while(right>=0) {
            if(str.charAt(left)==str.charAt(right)) {
                left++;
                right--;
            }
            else if(left==0) {
                right--;
            }
            else {
                left = 0;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        String str = "abbaaba";
//        String str = "abbaabba";
//        String str = "cabbacabba";
//        String str = "abcaaba";
        System.out.println(longestPalindromeStartingLeft(str));
    }

}
