package com.pli.project.algorithm.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2015/12/12.
 */
public class BinarySearch {


    public static void main(String[] args) {

    }

    public int findLeftInclusive(int[] nums, int target) {
        if (target < nums[0]) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target >= nums[mid]) {
                if (target < nums[mid + 1]) {
                    return mid;
                }
                else {
                    left = mid + 1;
                }
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }

}