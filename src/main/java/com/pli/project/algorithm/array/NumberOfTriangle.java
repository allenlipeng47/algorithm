package com.pli.project.algorithm.array;

import java.util.Arrays;

/**
 * Created by pli on 12/22/2015.
 * Given an array with all element greater than 0. Find the number of group which it can group to a triangle
 * Given {3, 4, 5}, return 1
 * Given {3, 4, 5, 6}, return 4
 */
public class NumberOfTriangle {

    public static int getNumberOfTriangle(int[] arr) {
        assert arr!=null && arr.length>3;
        Arrays.sort(arr);
        int num = 0;
        for(int i=0; i<arr.length-2; i++) {
            int k = i+2;
            for(int j=i+1; j<arr.length-1; j++) {
                while (k<arr.length && arr[i]+arr[j]>arr[k])
                    k++;
                num = num + k - j - 1;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6};
        System.out.println(getNumberOfTriangle(arr));
    }

}
