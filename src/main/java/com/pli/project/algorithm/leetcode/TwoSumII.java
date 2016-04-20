package com.pli.project.algorithm.leetcode;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/4/20.
 */
public class TwoSumII {

    public static int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            int searchNum = target - numbers[i];
            int left = 0, right = len - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] < searchNum) {
                    left = mid + 1;
                }
                else if (numbers[mid] > searchNum) {
                    right = mid - 1;
                }
                else if (i == mid) {    // result should have different indices
                    break;
                }
                else {
                    return new int[] {i, mid};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {-3, -1, 2, 3, 6, 8};
        int[] nums = twoSum(numbers, 14);
        System.out.println(Arrays.toString(nums));
    }
}
