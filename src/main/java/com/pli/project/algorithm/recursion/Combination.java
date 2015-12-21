package com.pli.project.algorithm.recursion;

/**
 * Created by pli on 12/21/2015.
 */
public class Combination {

    public static void combination(char[] chs) {
        combinationHelper(chs, 0, new StringBuffer());
    }

    public static void combinationHelper(char[] chs, int index, StringBuffer sb) {
        for(int i=index; i<chs.length; i++) {
            sb.append(chs[i]);
            System.out.println(sb);
            combinationHelper(chs, i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        char[] chs = {'a', 'b', 'c'};
        combination(chs);
    }

}
