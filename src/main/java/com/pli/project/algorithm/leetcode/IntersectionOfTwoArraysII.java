package com.pli.project.algorithm.leetcode;

import java.util.*;

/**
 * Created by lipeng on 2016/6/6.
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 */
public class IntersectionOfTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hm1 = new HashMap<>();
        Map<Integer, Integer> hm2 = new HashMap<>();
        for (int i : nums1) {
            Integer value = hm1.get(i);
            if (value == null) {
                hm1.put(i, 1);
            }
            else {
                hm1.put(i, ++value);
            }
        }
        for (int i : nums2) {
            Integer value = hm2.get(i);
            if (value == null) {
                hm2.put(i, 1);
            }
            else {
                hm2.put(i, ++value);
            }
        }
        int size = 0;
        for (Map.Entry<Integer, Integer> entry1 : hm1.entrySet()) {
            Integer count2 = hm2.get(entry1.getKey());
            if (count2 != null) {
                size += Math.min(entry1.getValue(), count2);
            }
        }
        int[] ans = new int[size];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry1 : hm1.entrySet()) {
            Integer count2 = hm2.get(entry1.getKey());
            if (count2 != null) {
                int key = entry1.getKey();
                int n = Math.min(entry1.getValue(), count2);
                for (int j = 0; j < n; j++, i++) {
                    ans[i] = key;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2, 1, 1};
        int[] ans = intersect(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }

}
