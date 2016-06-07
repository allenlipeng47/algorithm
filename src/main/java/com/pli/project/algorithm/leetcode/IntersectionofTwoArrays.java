package com.pli.project.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by lipeng on 2016/6/6.
 * Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 https://leetcode.com/problems/intersection-of-two-arrays/#

 Note:
 Each element in the result must be unique.
 The result can be in any order.
 */
public class IntersectionofTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> ansHelper = new HashSet<>();
        for (int i : nums1) {
            hs.add(i);
        }
        for (int i : nums2) {
            if (hs.contains(i)) {
                ansHelper.add(i);
            }
        }
        int n = ansHelper.size();
        int[] ans = new int[n];
        int i = 0;
        for (int num : ansHelper) {
            ans[i++] = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 1};
        int[] nums2 = {1, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }


}
