package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lipeng on 2016/7/11.
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 */
public class FindKParisWithSmallestSums {

    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ans = new ArrayList<>();
        int[] index = new int[nums1.length];
        k = Math.min(nums2.length * nums1.length, k);
        while (k-- > 0) {
            int smallIndex = -1, smallSum = Integer.MAX_VALUE;
            for (int i = 0; i < nums1.length; i++) {
                if (index[i] >= nums2.length) {
                    continue;
                }
                int currSum = nums1[i] + nums2[index[i]];
                if (currSum < smallSum) {
                    smallIndex = i;
                    smallSum = currSum;
                }
            }
            ans.add(new int[]{nums1[smallIndex], nums2[index[smallIndex]]});
            index[smallIndex]++;
        }
        return ans;
    }

    public static void main(String[] args) {
//        List<int[]> ans = kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
//        List<int[]> ans = kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2);
//        List<int[]> ans = kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3);
        List<int[]> ans = kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10);
        ans.forEach(p -> System.out.println(p[0] + ", " + p[1]));
    }

}
