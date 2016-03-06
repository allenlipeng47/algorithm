package com.pli.project.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pli on 12/21/2015.
 * Permutation without duplicate. Assume array are sorted.
 * {1, 2, 2}, should return {1}, {2}, {2, 2}, {1, 2}, {1, 2, 2}
 */
public class Permutation4 {

    public static List<List<Integer>> getPermutation(int[] arr) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        getPermutationHelper(arr, new boolean[arr.length], 0, ans, new ArrayList<Integer>());
        return ans;
    }

    public static void getPermutationHelper(int[] arr, boolean[] used, int n, List<List<Integer>> ans, List<Integer> currAns) {
        if (n == arr.length) {
            ans.add(new ArrayList<Integer>(currAns));
            return;
        }
        if (n >= 1 && arr[n] == arr[n - 1] && used[n - 1] == false) {
            return;
        }
        getPermutationHelper(arr, used, n + 1, ans, currAns);   // doesn't select arr[n]
        currAns.add(arr[n]);    // select arr[n]
        used[n] = true;
        getPermutationHelper(arr, used, n + 1, ans, currAns);
        currAns.remove(currAns.size() - 1);
        used[n] = false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        System.out.println(getPermutation(arr));
    }
}



