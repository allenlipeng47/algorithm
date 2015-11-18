package com.pli.project.algorithm.array;

import java.util.Arrays;

/**
 * Created by lipeng on 2015/11/17.
 */
public class KMP {

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

    public static boolean match(String s, String t) {
        int[] next = getNext(t);
        int i=0, j=0;
        while(i<s.length() && j<t.length()) {
            if(s.charAt(i)==t.charAt(j)) {
                i++;
                j++;
            }
            else if(j==0) {
                i++;
            }
            else {
                j = next[j];
            }
        }
        if(j>=t.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        String t = "adabcabcefabcadabcacabcd";
//        String s = "abcacabcd";
        String s = "aac";
        String t = "ac";
        System.out.println(match(s, t));
    }

}
