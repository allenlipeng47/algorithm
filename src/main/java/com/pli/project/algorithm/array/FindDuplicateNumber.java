package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2015/10/18.
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i]>0) {
                int pointer = nums[i]-1;
                while(nums[pointer]>=0 && pointer!=i) {
                    nums[pointer] = -nums[pointer];
                    pointer = (-nums[pointer]) - 1;
                }
                if(pointer!=i) {
                    return pointer+1;
                }
                else {
                    nums[i] = -nums[i];
                }
            }
        }
        for(int i=0; i<nums.length; i++) {
            nums[i] = nums[i]<0?-nums[i]:nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] arr = {3, 1, 4, 2, 4};
//        int[] arr = {1, 2, 3, 4, 4};
        int[] arr = {4, 2, 1, 3, 1};
        System.out.println(findDuplicate(arr));
    }

}
