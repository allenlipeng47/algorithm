package com.pli.project.algorithm.array;

import java.util.Arrays;

/**
 * Created by lipeng on 2015/12/30.
 * leetcode https://leetcode.com/problems/create-maximum-number/
 */
public class CreateMaximumNumber {

    public static int[] maxNumber(int[] arr1, int[] arr2, int k) {
        if(arr1==null || arr2==null || arr1.length + arr2.length < k)
            return null;
        HelperSet set1 = new HelperSet(arr1);
        HelperSet set2 = new HelperSet(arr2);
        String resultStr = pickup(set1, set2, k);
        int[] result = new int[resultStr.length()];
        for(int i=0; i<result.length; i++) {
            result[i] = Integer.valueOf(String.valueOf(resultStr.charAt(i)));
        }
        return result;
    }

    // separately in set1, set2, starting from start, pickup the next largest number
    private static String pickup(HelperSet set1, HelperSet set2, int k) {
        if(set1.start>=set1.arr.length)
            return set2.restResult();
        if(set2.start>=set2.arr.length)
            return set1.restResult();
        // initial end pos of set1 and set2 before entering the loop
        set1.end = set1.arr.length - 1;
        set2.end = set2.arr.length - 1;
        while (true) {
            int maxPos1 = set1.getLargestPos();
            int maxPos2 = set2.getLargestPos();
            // the values in max position in set1 and set2 are equal.
            if(set1.arr[maxPos1]==set2.arr[maxPos2]) {
                String result1=null, result2=null;
                HelperSet tmpSet1 = null, tmpSet2 = null;
                if((set1.arr.length-maxPos1-1)+(set2.arr.length-set2.start)>=k-1) {  // try max value in set1
                    tmpSet1 = set1.clone();
                    tmpSet1.start = maxPos1 + 1;
                    result1 = String.valueOf(set1.arr[maxPos1]) + pickup(tmpSet1, set2, k-1);
                }
                if((set2.arr.length-maxPos2-1)+(set1.arr.length-set1.start)>=k-1) {  // try max value in set2
                    tmpSet2 = set2.clone();
                    tmpSet2.start = maxPos2 + 1;
                    result2 = String.valueOf(set2.arr[maxPos2]) + pickup(set1, tmpSet2, k-1);
                }
                /* both null, it means both choice won't have total length greater than k.
                    Will update end in both set and continue loop    */
                if(result1==null&&result2==null) {
                    set1.end = maxPos1 - 1;
                    set2.end = maxPos2 - 1;
                    continue;
                }
                if(result1==null && result2!=null)
                    return result2;
                if(result1!=null && result2==null)
                    return result1;
                if(result1.compareTo(result2)>=0)
                    return result1;
                else
                    return result2;
            }
            HelperSet greaterSet=null, smallerSet=null;
            int greatMaxPos = 0;
            if(set1.arr[maxPos1]>set2.arr[maxPos2]) {   // process can go here, values in max position in set1 and set2 are not equal.
                greaterSet = set1;
                smallerSet = set2;
                greatMaxPos = maxPos1;
            }
            if(set1.arr[maxPos1]<set2.arr[maxPos2]) {
                greaterSet = set2;
                smallerSet = set1;
                greatMaxPos = maxPos2;
            }
            // it is possible to use max value in greater set. Then go to next iteration.
            if((greaterSet.arr.length-greatMaxPos-1)+(smallerSet.arr.length-smallerSet.start)>=k-1) {
                greaterSet.start = greatMaxPos + 1;
                return String.valueOf(greaterSet.arr[greatMaxPos]) + pickup(greaterSet, smallerSet, k-1);
            }
            else {  // if it is not possible, update greater set end position and continue loop
                greaterSet.end = greatMaxPos - 1;
            }
        }
    }

    private static class HelperSet {
        final int[] arr;
        public int start;
        public int end;
        public int[][] maxArr; // maxArr[i][j] is the max value between arr[i],...,arr[j]
        public HelperSet(int[] arr) {
            this.arr = arr;
            start = 0;
            end = arr.length - 1;
            buildMaxArr();
        }

        public HelperSet(int[] arr, int[][] maxArr, int start, int end) {
            this.arr = arr;
            this.maxArr = maxArr;
            this.start = start;
            this.end = end;
        }

        public HelperSet clone() {
            return new HelperSet(this.arr, this.maxArr, this.start, this.end);
        }

        // there is case when printing arr from start to its length;
        public String restResult() {
            StringBuffer result = new StringBuffer();
            for(int i = start; i<arr.length; i++) {
                result.append(arr[i]);
            }
            return result.toString();
        }

        private void buildMaxArr() {
            maxArr = new int[arr.length][arr.length];
            for(int i=0; i<arr.length; i++)
                maxArr[i][i] = i;
            for(int i=1; i<arr.length; i++) {
                for(int j=0; j<arr.length-i; j++) {
                    if(arr[maxArr[j][j + i - 1]] > arr[maxArr[j + 1][j + i]])
                        maxArr[j][j + i] = maxArr[j][j + i - 1];
                    else
                        maxArr[j][j + i] = maxArr[j + 1][j + i];
                }
            }
        }

        // for arr, return index of max value between [start,...,end]
        private int getLargestPos() {
            return maxArr[start][end];
        }
    }

    public static void main(String[] args) {
//        int[] arr1 = {3, 4, 6, 5}, arr2 = {9, 1, 2, 5, 8, 3}; int k = 5;
//        int[] arr1 = {6, 7}, arr2 = {6, 0, 4}; int k = 5;
//        int[] arr1 = {3, 9}, arr2 = {8, 9}; int k = 3;
//        int[] arr1 = {2, 5, 6, 4, 4, 0}, arr2 = {7, 3, 8, 0, 6, 5, 7, 6, 2}; int k = 15;
        int[] arr1 = {2,1,2,1,2,2,1,2,2,1,1,2,1,0,2,0,1,0,1,1,2,0,0,2,2,2,2,1,1,1,2,1,2,0,2,0,1,1,0,1,0,2,0,1,0,2,0,1,1,0,0,2,0,1,1,2,0,2,2,1,2,1,2,1,0,1,2,0,2,1,2,2,2,0,1,1,0,2,0,1,1,0,0,0,2,1,1,1,0,1,1,0,1,2,1,2,0,0,0,2,1,2,2,1,1,0,1,1,0,0,1,0,0,0,2,1,1,0,2,0,2,2,0,2,0,0,2,0,1,2,1,1,1,2,1,0,1,1,0,2,1,2,2,1,0,1,1,1,2,0,2,2,2,0,2,1,1,2,1,1,2,0,2,1,0,2,0,0,2,2,2,0,2,1,2,2,1,2,1,2,2,2,1,1,2,0,2,0,0,2,2,2,0,2,2,1,0,0,2,2,2,1,1,0,2,1,0,1,2,1,1,2,2,1,1,0,2,1,2,2,1,2,1,0,0,0,0,1,1,0,2,2,2,2,2,2,2,2,1,1,0,2,1,0,0,0,0,2,1,1};
        int[] arr2 = {1,1,0,2,0,1,1,1,0,2,2,2,1,1,0,1,2,1,2,1,0,1,2,2,2,2,1,1,0,2,0,1,0,0,1,1,0,1,2,1,2,1,2,0,1,1,1,1,2,0,1,1,1,0,0,1,0,1,2,1,1,0,2,2,1,2,0,2,0,1,1,2,0,1,1,2,2,1,0,1,2,2,0,1,1,2,2,0,2,2,0,2,1,0,0,2,1,0,0,2,1,2,1,2,0,2,0,1,1,2,1,1,1,2,0,2,2,0,2,2,0,2,1,2,1,2,0,2,0,0,1,2,2,2,2,1,2,2,0,1,0,0,2,2,2,2,0,1,0,2,1,2,2,2,1,1,1,1,2,0,0,1,0,0,2,2,1,0,0,1,1,0,0,1,1,0,2,2,2,2,2,1,0,2,2,0,0,1,0,0,1,1,1,2,2,0,0,2,0,0,0,1,2,0,2,0,1,2,0,1,2,0,1,1,0,0,1,2,1,0,2,1,0,1,2,0,1,1,2,1,0,2,1,2,1,1,0,2,2,1,0,2,1,1,1,0,0,0,1,0};
        int k = 500;
        int[] result = maxNumber(arr1, arr2, k);
        System.out.println(Arrays.toString(result));
    }


}
