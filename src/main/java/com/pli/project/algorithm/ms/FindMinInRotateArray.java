package com.pli.project.algorithm.ms;

/**
 * Created by lipeng on 2016/3/19.
 */
public class FindMinInRotateArray {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else if (nums[mid] < nums[right]){
                right = mid;
            }
            else {
                right--;
            }
        }
        return nums[left];
    }

    public int findMin3(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[left]) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public int findMin2(int[] num) {
        int low = 0;
        int high = num.length - 1;
        while(low < high){
            int mid = (low + high) / 2;
            if(num[high] < num[mid]){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return num[high];
    }

    public static void main(String[] args) {
        FindMinInRotateArray find = new FindMinInRotateArray();
        int[] nums = {2, 1};
        System.out.println(find.findMin(nums));
    }




}
