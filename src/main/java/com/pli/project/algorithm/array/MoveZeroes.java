package com.pli.project.algorithm.array;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/1/17.
 */
public class MoveZeroes {

    public static void moveZeroes2(int[] nums) {
        int i = 0, zeroPos = nums.length - 1;
        while (i < zeroPos) {
            if (nums[i] == 0) { // shift i, i + 1, ..., zeroPos to left one position
                for(int j = i; j < zeroPos; j++)
                    nums[j] = nums[j + 1];
                nums[zeroPos--] = 0;
            }
            else
                i++;
        }
    }

    public static void moveZeroes(int[] nums) {
        int zeroPos = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[zeroPos++] = nums[i];
        }
        for(; zeroPos < nums.length; zeroPos++)
            nums[zeroPos] = 0;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }


}
