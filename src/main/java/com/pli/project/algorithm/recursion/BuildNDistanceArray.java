package com.pli.project.algorithm.recursion;

import java.util.Arrays;

/**
 * Created by lipeng on 2015/11/26.
 * Given a number n. Build an array with length 2*n, with element 1, 2, ..., n.
 * 1, 2, 3, ..., n appears 2 times. For 2 element i, the distance between i should be greater than i
 * For example, if n=4, one of output is [2, 3, 4, 2, 1, 3, 1, 4]
 */
public class BuildNDistanceArray {

    public static int[] buildNDistance(int n) {
        int[] result = new int[2*n];
        boolean[] used = new boolean[n+1];
        return buildNDistanceHelper(0, result, used);
    }

    public static int[] buildNDistanceHelper(int k, int[] result, boolean[] used) {
        if(k>=used.length-1) {
            return result;
        }
        int pos = 0;
        for(pos=k; pos<result.length && result[pos]!=0; pos++);
        // set position for result[i];
        for(int i=1; i<used.length && pos+i+1<result.length; i++) {
            if(!used[i]) {
                if(result[pos+i+1]==0) {
                    result[pos] = result[pos+i+1] = i;
                    used[i] = true;
                    int[] currResult = buildNDistanceHelper(k + 1, result, used);
                    if(currResult!=null) {
                        return currResult;
                    }
                    result[pos] = result[pos+i+1] = 0;
                    used[i] = false;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] result = buildNDistance(4);
        System.out.println(Arrays.toString(result));
    }

}
