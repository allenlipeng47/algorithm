package com.pli.project.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by lipeng on 2015/10/19.
 * https://leetcode.com/problems/permutation-sequence/
 */
public class Permutation {

    public static String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }
        int[] set = new int[arr.length];
        HashSet<Integer> used = new HashSet<Integer>();
        int[] kth = new int[1];
        return permutationUtil(arr, 0, set, 0, used, kth, k-1);
    }

    public static String permutationUtil(int[] arr, int arrId, int[] set, int setId, HashSet<Integer> used, int[] kth, int k) {
        if(setId>=3) {
            if(kth[0]==k) {
                String result = "";
                for(int i=0; i<set.length; i++) {
                    result += set[i];
                }
                return result;
            }
            else {
                kth[0]++;
            }
        }
        for(int i=0; i<arr.length; i++) {
            if(!used.contains(i)) {
                used.add(i);
                set[setId] = arr[i];
                String result =  permutationUtil(arr, arrId+1, set, setId+1, used, kth, k);
                if(result!=null){
                    return result;
                }
                set[setId] = 0;
                used.remove(i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(getPermutation(4, 1));
    }
}



