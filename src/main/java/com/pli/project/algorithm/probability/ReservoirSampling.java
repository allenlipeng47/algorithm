package com.pli.project.algorithm.probability;

import java.util.Arrays;

/**
 * Created by lipeng on 2015/5/25.
 */
public class ReservoirSampling {

    /**
     * Suppose arr is a very large array, can't be stored in memory.
     * Randomly select m element among arr.
     * @param arr, the input array. Very large, can't be stored in memory.
     * @param m, the size of reservoir
     * @return, the sampling result.
     */
    public static int[] reservoirSampling(int[] arr, int m){
        if(arr==null || m > arr.length){
            return null;
        }
        int[] result = Arrays.copyOf(arr, m);
        for(int i = m; i < arr.length; i++){
            int randPos = (int)(Math.random() * i);
            if(randPos < m){
                result[randPos] = arr[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] result = reservoirSampling(arr, 3);
        System.out.println(Arrays.toString(result));
    }

}
