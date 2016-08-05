package com.pli.project.algorithm.leetcode;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/8/4.
 * https://leetcode.com/problems/merge-sorted-array/
 * Loop from end to start. In this way, we don't need extra space, can do in-place.
 */
public class l88MergeTwoSortedArray {

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] aux = Arrays.copyOf(nums1, nums1.length);
        int i = 0, j = 0, k = 0;
        while (j < m && k < n) {
            if (aux[j] < nums2[k]) {
                nums1[i++] = aux[j++];
            }
            else {
                nums1[i++] = nums2[k++];
            }
        }
        while (j < m) {
            nums1[i++] = aux[j++];
        }
        while (k < n) {
            nums1[i++] = nums2[k++];
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[k--] = nums1[m--];
            }
            else {
                nums1[k--] = nums2[n--];
            }
        }
        while (m >= 0) {
            nums1[k--] = nums1[m--];
        }
        while (n >= 0) {
            nums1[k--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
            int[] nums1 = {0};
        int[] nums2 = {1};
        merge2(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }

}
