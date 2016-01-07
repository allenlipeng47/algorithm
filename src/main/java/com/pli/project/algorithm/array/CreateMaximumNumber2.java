package com.pli.project.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by lipeng on 2015/12/30.
 * leetcode https://leetcode.com/problems/create-maximum-number/
 * Solution: http://algobox.org/2015/12/24/create-maximum-number/
 * This code passed oj.
 */
public class CreateMaximumNumber2 {


    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];
        // At the beginning try to get as much element as possible from nums1.
        // And should guarantee rest of element is greater less than m
        for(int i = Math.min(k, n); k - i <= m && i >= 0; i--) {
            int[] left = maxNumber(nums1, i);
            int[] right = maxNumber(nums2, k - i);
            int[] candidate = merge(left, right, k);
            ans = compare(ans, 0, candidate, 0) > 0 ? ans : candidate;
            candidate = null;
        }
        return ans;
    }

    private static int[] maxNumber(int[] num, int k) {
        int n = num.length;
        int[] ans = new int[Math.min(n, k)];
        for(int i = 0, j = 0; i < n; i++) {
            while (j > 0 && num[i] > ans[j - 1] && k - j < n - i )
                j--;
            if(j < k)
                ans[j++] = num[i];
        }
        return ans;
    }

    public static int[] merge(int[] num1, int[] num2, int k) {
        int n = num1.length;
        int m = num2.length;
        int[] ans = new int[k];
        int i = 0, j = 0, pos = 0;
        while (i < n && j < m && pos < k) {
            int cmp = compare(num1, i, num2, j);
            if(cmp > 0)
                ans[pos++] = num1[i++];
            else
                ans[pos++] = num2[j++];
        }
        while (i < n && pos < k)
            ans[pos++] = num1[i++];
        while (j < m && pos < k)
            ans[pos++] = num2[j++];
        return ans;
    }

    private static int compare(int[] num1, int i, int[] num2, int j) {
        if(num1==null)
            return -1;
        int n = num1.length;
        int m = num2.length;
        while (i < n && j < m) {
            if(num1[i] != num2[j])
                return num1[i] - num2[j];
            i++;
            j++;
        }
        return (n - i) - (m - j);
    }

    public static void main(String[] args) {
        test();
//        oneArrayTest();
    }

    public static void oneArrayTest() {
        int[] arr = {6, 0, 4};
        int[] ans = maxNumber(arr, 2);
        System.out.println(Arrays.toString(ans));
    }

    public static void test() {
//                int[] arr1 = {3, 4, 6, 5}, arr2 = {9, 1, 2, 5, 8, 3}; int k = 5;
//        int[] arr1 = {6, 7}, arr2 = {6, 0, 4}; int k = 5;
        int[] arr1 = {}, arr2 = {1}; int k = 1;
//        int[] arr1 = {3, 9}, arr2 = {8, 9}; int k = 3;
//        int[] arr1 = {2, 5, 6, 4, 4, 0}, arr2 = {7, 3, 8, 0, 6, 5, 7, 6, 2}; int k = 15;
//        int[] arr1 = {2,1,2,1,2,2,1,2,2,1,1,2,1,0,2,0,1,0,1,1,2,0,0,2,2,2,2,1,1,1,2,1,2,0,2,0,1,1,0,1,0,2,0,1,0,2,0,1,1,0,0,2,0,1,1,2,0,2,2,1,2,1,2,1,0,1,2,0,2,1,2,2,2,0,1,1,0,2,0,1,1,0,0,0,2,1,1,1,0,1,1,0,1,2,1,2,0,0,0,2,1,2,2,1,1,0,1,1,0,0,1,0,0,0,2,1,1,0,2,0,2,2,0,2,0,0,2,0,1,2,1,1,1,2,1,0,1,1,0,2,1,2,2,1,0,1,1,1,2,0,2,2,2,0,2,1,1,2,1,1,2,0,2,1,0,2,0,0,2,2,2,0,2,1,2,2,1,2,1,2,2,2,1,1,2,0,2,0,0,2,2,2,0,2,2,1,0,0,2,2,2,1,1,0,2,1,0,1,2,1,1,2,2,1,1,0,2,1,2,2,1,2,1,0,0,0,0,1,1,0,2,2,2,2,2,2,2,2,1,1,0,2,1,0,0,0,0,2,1,1};
//        int[] arr2 = {1,1,0,2,0,1,1,1,0,2,2,2,1,1,0,1,2,1,2,1,0,1,2,2,2,2,1,1,0,2,0,1,0,0,1,1,0,1,2,1,2,1,2,0,1,1,1,1,2,0,1,1,1,0,0,1,0,1,2,1,1,0,2,2,1,2,0,2,0,1,1,2,0,1,1,2,2,1,0,1,2,2,0,1,1,2,2,0,2,2,0,2,1,0,0,2,1,0,0,2,1,2,1,2,0,2,0,1,1,2,1,1,1,2,0,2,2,0,2,2,0,2,1,2,1,2,0,2,0,0,1,2,2,2,2,1,2,2,0,1,0,0,2,2,2,2,0,1,0,2,1,2,2,2,1,1,1,1,2,0,0,1,0,0,2,2,1,0,0,1,1,0,0,1,1,0,2,2,2,2,2,1,0,2,2,0,0,1,0,0,1,1,1,2,2,0,0,2,0,0,0,1,2,0,2,0,1,2,0,1,2,0,1,1,0,0,1,2,1,0,2,1,0,1,2,0,1,1,2,1,0,2,1,2,1,1,0,2,2,1,0,2,1,1,1,0,0,0,1,0};
//        int k = 500;
        // int[] result = [2, 1, 2, 1, 2, 2, 1, 2, 2, 1, 1, 2, 1, 1, 1, 0, 2, 0, 2, 0, 1, 1, 1, 0, 2, 2, 2, 1, 1, 0, 1, 2, 1, 2, 1, 0, 1, 2, 2, 2, 2, 1, 1, 0, 2, 0, 1, 0, 1, 1, 2, 0, 1, 0, 0, 2, 2, 2, 2, 1, 1, 1, 2, 1, 2, 0, 2, 0, 1, 1, 0, 1, 0, 2, 0, 1, 0, 2, 0, 1, 1, 0, 0, 2, 0, 1, 1, 2, 0, 2, 2, 1, 2, 1, 2, 1, 0, 1, 2, 0, 2, 1, 2, 2, 2, 0, 1, 1, 0, 2, 0, 1, 1, 0, 0, 1, 1, 0, 1, 2, 1, 2, 1, 2, 0, 1, 1, 1, 1, 2, 0, 1, 1, 1, 0, 0, 1, 0, 1, 2, 1, 1, 0, 2, 2, 1, 2, 0, 2, 0, 1, 1, 2, 0, 1, 1, 2, 2, 1, 0, 1, 2, 2, 0, 1, 1, 2, 2, 0, 2, 2, 0, 2, 1, 0, 0, 2, 1, 0, 0, 2, 1, 2, 1, 2, 0, 2, 0, 1, 1, 2, 1, 1, 1, 2, 0, 2, 2, 0, 2, 2, 0, 2, 1, 2, 1, 2, 0, 2, 0, 0, 1, 2, 2, 2, 2, 1, 2, 2, 0, 1, 0, 0, 2, 2, 2, 2, 0, 1, 0, 2, 1, 2, 2, 2, 1, 1, 1, 1, 2, 0, 0, 1, 0, 0, 2, 2, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 2, 2, 2, 2, 2, 1, 0, 2, 2, 0, 0, 1, 0, 0, 1, 1, 1, 2, 2, 0, 0, 2, 0, 0, 0, 2, 1, 1, 1, 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 2, 1, 2, 2, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 2, 1, 1, 0, 2, 0, 2, 2, 0, 2, 0, 0, 2, 0, 1, 2, 1, 1, 1, 2, 1, 0, 1, 1, 0, 2, 1, 2, 2, 1, 0, 1, 1, 1, 2, 0, 2, 2, 2, 0, 2, 1, 1, 2, 1, 1, 2, 0, 2, 1, 0, 2, 0, 0, 2, 2, 2, 0, 2, 1, 2, 2, 1, 2, 1, 2, 2, 2, 1, 1, 2, 0, 2, 0, 0, 2, 2, 2, 0, 2, 2, 1, 0, 0, 2, 2, 2, 1, 1, 0, 2, 1, 0, 1, 2, 1, 1, 2, 2, 1, 1, 0, 2, 1, 2, 2, 1, 2, 1, 0, 0, 0, 1, 2, 0, 2, 0, 1, 2, 0, 1, 2, 0, 1, 1, 0, 0, 1, 2, 1, 0, 2, 1, 0, 1, 2, 0, 1, 1, 2, 1, 0, 2, 1, 2, 1, 1, 0, 2, 2, 1, 0, 2, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 0, 2, 1, 0, 0, 0, 0, 2, 1, 1];
        int[] result = maxNumber(arr1, arr2, k);
        System.out.println(Arrays.toString(result));
    }


}
