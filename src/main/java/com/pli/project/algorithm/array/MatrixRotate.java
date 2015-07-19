package com.pli.project.algorithm.array;

import junit.framework.Assert;

import java.util.Arrays;

/**
 * Created by lipeng on 2015/7/16.
 */
public class MatrixRotate {

    public static int[][] rotateArray(int[][] arr){
        Assert.assertNotNull(arr);
        Assert.assertNotNull(arr[0]);
        int layerNum = Math.max(arr.length, arr[0].length) / 2;
        for(int i=0; i<layerNum; i++){
            /* Each loop, is to renew each layer. Layer loops from outside to inside */
            int left = i, right = arr[0].length-1-i, top = i, bottom = arr.length-1-i;
            int tmp = arr[top][left];
            /* From left to right*/
            for(int j=top; j<bottom; j++){
                arr[j][left] = arr[j+1][left];
            }
            /* From top to bottom */
            for(int j=left; j<right; j++){
                arr[bottom][j] = arr[bottom][j+1];
            }
            /* From right to left */
            for(int j=bottom; j>top; j--){
                arr[j][right] = arr[j-1][right];
            }
            /* From bottom to top */
            for(int j=right; j>left; j--){
                arr[top][j] = arr[top][j-1];
            }
            arr[top][left+1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        arr = rotateArray(arr);
        for(int[] subArr:arr){
            System.out.println(Arrays.toString(subArr));
        }
    }
}
