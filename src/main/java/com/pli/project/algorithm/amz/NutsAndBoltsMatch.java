package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/8/12.
 */
public class NutsAndBoltsMatch
{

    public void nutsBolts(int[] nuts, int[] bolts) {
        helper(nuts, bolts, 0, nuts.length - 1);
    }

    private void helper(int[] nuts, int[] bolts, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(nuts, left, right, nuts[0]);
        partition(bolts, left, right, nuts[pivot]);
        helper(nuts, bolts, left, pivot - 1);
        helper(nuts, bolts, pivot + 1, right);
    }

    private int partition(int[] nums, int left, int right, int pivot) {
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
            else if (nums[j] == pivot) {
                swap(nums, j, right);
                j--;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}