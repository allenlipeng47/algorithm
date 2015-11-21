package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2015/11/17.
 */
public class LongestPalindromeStartingLeft {

    public static int longestPalindromeStartingLeftNaive(String str) {
        str = str + new StringBuilder(str).reverse().toString();
        System.out.println(str);
        int i=0, j=str.length() / 2;
        int[] next = getNext(str);
        while(j<str.length()) {
            if(str.charAt(i)==str.charAt(j)) {
                i++;
                j++;
            }
            else if(i==0) {
                j++;
            }
            else {
                i = next[i];
            }
        }
        return i;
    }

    public static int longestPalindromeStartingLeft(String str) {
        int left=0, right=str.length()-1;
        int[] next = getNext(str);
        while(right>=0) {
            if(str.charAt(left)==str.charAt(right)) {
                left++;
                right--;
            }
            else if(left==0) {
                right--;
            }
            else {
                left = next[left];
            }
        }
        return left;
    }

    public static int[] getNext(String t) {
        if(t==null) {
            return null;
        }
        int[] next = new int[t.length()];
        if(t.length()<3) {
            return next;
        }
        int i=0, j=1;
        int len = 0;
        while(j<t.length()-1) {
            if(t.charAt(i)==t.charAt(j)) {
                next[j+1] = ++len;
                i++;
            }
            else {
                i = 0;
                len = 0;
            }
            j++;
        }
        return next;
    }

    public static void main(String[] args) {
//        String str = "abbaaba";
//        String str = "abbaabba";
//        String str = "cabbacabba";
//        String str = "abcaaba";
        String str = "aaabaaaaa";
//        System.out.println(longestPalindromeStartingLeft(str));
        System.out.println(longestPalindromeStartingLeftNaive(str));
    }

}
