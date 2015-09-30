package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2015/9/1.
 */
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        if(nums==null){
            return -1;
        }
        int sum = (nums.length + 1) * (nums.length) / 2;
        for(int i=0; i<nums.length; i++){
            sum -= nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3};
        int result = missingNumber(nums);
        System.out.println(result);
    }
}
