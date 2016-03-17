package com.pli.project.algorithm.array;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LengthOfLIS {



    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> order = new ArrayList<>();
        for (int i : nums) {
            int target = findPos(order, i);
            if (target >= order.size() - 1) { // at last position
                if (order.size() == 0 || i > order.get(target)) {
                    order.add(i);
                }
            }
            else if (i < order.get(target + 1) && target >= 0 && i != order.get(target) || target == -1) {
                    order.set(target + 1, i);
                }
            }
        return order.size();
    }

    public int findPos(ArrayList<Integer> list, int ele) {
        if (list == null || list.size() <= 0) {
            return -1;
        }
        int left = 0, right = list.size() - 1;
        if (ele >= list.get(right)) {
            return right;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (ele >= list.get(mid)) {
                if (ele < list.get(mid + 1)) {
                    return mid;
                }
                else {
                    left = mid;
                }
            }
            else {
                right = mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        LengthOfLIS t1 = new LengthOfLIS();
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
//        int[] nums = {2, 2};
//        int[] nums = {10,9,2,5,3,7,101,18};
//        int[] nums = {3,5,6,2,5,4,19,5,6,7,12};
//        int[] nums = {1, 2, 3, 4,5 , 6};
        int[] nums = {10,9,2,5,3,7,101,18};
//        System.out.println(Arrays.binarySearch(nums, 3));
        System.out.println(t1.lengthOfLIS(nums));
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{1, 3, 5}));
//        System.out.println(t1.findPos(list, 2));
    }

}