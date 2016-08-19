package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2016/2/15.
 */
public class IncreasingTriplet {

    public static boolean increasingTriplet2(int[] nums) {
        int firstPos, secondPos = 1;
        for (; secondPos < nums.length && nums[secondPos] <= nums[secondPos - 1]; secondPos++);
        firstPos = secondPos - 1;
        for (int i = secondPos + 1; i < nums.length; i++) {
            if (nums[i] > nums[secondPos]) {
                return true;
            }
            if (nums[i] > nums[firstPos]) { // nums[i] is between firstPos and secondPos
                secondPos = i;
            }
            if (nums[i] > nums[i - 1]) {   // when meeting a new climbing point and is less, then update.
                secondPos = i;
                if (nums[i - 1] < nums[firstPos]) {
                    firstPos = i - 1;
                }
            }
        }
        return false;
    }

    public static boolean increasingTriplet(int[] nums) {
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i <= firstMin) {
                firstMin = i;
            }
            else if (i <= secondMin) {
                secondMin = i;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = {5, 4, 3, 2, 1};
//        int[] nums = {1,2,3,1,2,1};
//        int[] nums = {2, 1, 5, 0, 3};
//        int[] nums = {1, 0, 0, 1};
//        int[] nums = {5, 1, 5, 5, 2, 5, 4};
        int[] nums = {1, 2, 2};
        System.out.println(increasingTriplet(nums));
    }


}
