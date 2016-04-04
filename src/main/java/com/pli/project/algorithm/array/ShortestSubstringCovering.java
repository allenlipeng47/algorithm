package com.pli.project.algorithm.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by lipeng on 2015/12/6.
 * Given a long string s and short strings t1, t2, t3 (which can have different length) find the shortest substring of s which contains t1, t2 and t3
 */
public class ShortestSubstringCovering {

//    public static String shortestSubStringCovering(String str, String[] match) {
//        assert str!=null && match!=null;
//        int[][] next = new int[match.length][];
//        for(int i=0; i<match.length; i++)
//            next[i] = getNext(match[i]);
//        HashMap<String, ArrayDeque<String>> hm = new HashMap<String, ArrayDeque<String>>();   //to get the string position in queue
//        ArrayDeque<String> head, tail;
//        int[] arrPos = new int[match.length];
//        for(int i=0; i<str.length(); i++) {
//
//        }
//        return null;
//    }

    public static boolean compare(String str, String match) {
        int[] next = getNext(match);
        int i=0, j=0;
        while(i<str.length() && j<match.length()) {
            if(str.charAt(i)==match.charAt(j)) {
                i++; j++;
            }
            else if(j!=0) {
                j = next[j];
            }
            else {
                i++;
            }
        }
        return j>=match.length() ? true : false;
    }

    // build KMP next array
    public static int[] getNext(String str) {
        assert str!=null;
        int[] next = new int[str.length()];
        int i=0, j=2, len=0;
        while(i<str.length() && j<str.length()-1) {
            if(str.charAt(i)==str.charAt(j)) {
                next[j+1] = ++len;
                i++;
            }
            else {
                len = 0;
                i = 0;
            }
            j++;
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "THIS IS A TEST TEXT";
        String match = "TESTS";
        System.out.println(compare(str, match));
    }

}
