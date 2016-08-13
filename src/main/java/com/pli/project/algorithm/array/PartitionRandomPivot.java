package com.pli.project.algorithm.array;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/8/12.
 */
public class PartitionRandomPivot {

    public static int partition(int[] arr, int low, int high, int pivot) {
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot){
                swap(arr, i, j);
                i++;
            } else if(arr[j] == pivot){
                swap(arr, j, high);
                j--;
            }
        }
        swap(arr, i, high);
        return i;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 4, 1, 3};
        partition(nums, 0, nums.length - 1, 4);
        System.out.println(Arrays.toString(nums));

    }

}
