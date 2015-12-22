package com.pli.project.algorithm.array;

/**
 * Created by pli on 12/21/2015.
 * Given two sorted list, find the min distance of any 2 elements in 2 lists.
 * For example, {1, 10, 20} and {5, 15, 21} min=21-20=1
 * {1, 10} and {15, 21} min=15-10=5
 */
public class MinDistanceIn2List {

    // use merge sort. For each merge, do a comparison
    public static int minDistance2(int[] arr1, int[] arr2) {
        assert arr1!=null && arr2!=null && arr1.length>0 && arr2.length>0;
        int min=Integer.MAX_VALUE, i=0, j=0;
        while (i<arr1.length && j<arr2.length) {
            min = Math.min(Math.abs(arr1[i]-arr2[j]), min);
            if(arr1[i]<arr2[j])
                i++;
            else
                j++;
        }
        while (i<arr1.length)
            min = Math.min(arr1[i++]-arr2[j-1], min);
        while (j<arr2.length)
            min = Math.min(arr2[j++]-arr1[i-1], min);
        return min;
    }

    public static int minDistance(int[] arr1, int[] arr2) {
        assert arr1!=null && arr2!=null && arr1.length>0 && arr2.length>0;
        int[] preList=null;
        int i=0, j=0, minDistance = Integer.MAX_VALUE;
        while (i<arr1.length && j<arr2.length) {
            if(arr1[i]<arr2[j]) {
                if (preList == arr2)
                    minDistance = Math.min(Math.abs(arr2[j-1]-arr1[i]), minDistance);
                i++;
                preList = arr1;
            }
            else {
                if(preList==arr1)
                    minDistance = Math.min(Math.abs(arr1[i-1]-arr2[j]), minDistance);
                j++;
                preList = arr2;
            }
        }
        if(i>=arr1.length)
            minDistance = Math.min(Math.abs(arr1[i-1]-arr2[j]), minDistance);
        else
            minDistance = Math.min(Math.abs(arr2[j-1]-arr1[i]), minDistance);
        return minDistance;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 10, 20};
        int[] arr2 = {5, 15, 21};
//        int[] arr1 = {1, 2, 3, 4, 8, 9};
//        int[] arr2 = {15, 16, 19};
        System.out.println(minDistance2(arr1, arr2));
    }

}