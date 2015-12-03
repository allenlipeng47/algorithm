package com.pli.project.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by lipeng on 2015/12/2.
 */
public class SumOfSet {

/*
Given a integer array, and a number n. Return true if n can be consisted by a subset of array.
For example, arr[]={3, 2, 3, 5}, n=11, return true; arr[]={3, 2, 3, 5}, n=12, return false

 */
    public static boolean SumOfSet(int[] arr, int n) {
        assert arr!=null && arr.length>0;
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i:arr) {
            HashSet<Integer> tmp = new HashSet<Integer>();
            for(int j:hs)
                tmp.add(i+j);
            hs.addAll(tmp);
            hs.add(i);
        }
        return hs.contains(n);
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 5};
        System.out.println(SumOfSet(arr, 12));
    }

}
