package com.pli.project.algorithm.divideandconquer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/1/4.
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * Same as qaz problem
 */
public class CountSmallerNumberAfterSelf {

    public static List<Integer> countSmaller(int[] nums) {
        Rec[] recs = countSmallerHelper(nums, 0, nums.length - 1);
        List<Integer> ans = new ArrayList<Integer>();
        for(int i : nums)
            ans.add(0);
        for(Rec rec : recs)
            ans.set(rec.index, rec.num);
        return ans;
    }

    public static Rec[] countSmallerHelper(int[] nums, int i, int j) {
        if(i == j) {
            Rec[] ans = new Rec[1];
            ans[0] = new Rec(i, 0);
            return ans;
        }
        int mid = (i + j) / 2;
        Rec[] left = countSmallerHelper(nums, i, mid);
        Rec[] right = countSmallerHelper(nums, mid + 1, j);
        // merge here
        int ln = left.length, rn = right.length, l = 0, r = 0, count = 0, k = 0;
        Rec[] recs = new Rec[ln + rn];
        while (l < ln && r < rn) {
            if(nums[left[l].index] > nums[right[r].index]) {    // if right side is small, then increase count.
                count++;
                recs[k++] = right[r++];
            }
            else {  // if right side is small, update num and merge to recs.
                left[l].num += count;
                recs[k++] = left[l++];
            }
        }
        while (l < ln) {
            left[l].num += count;
            recs[k++] = left[l++];
        }
        while (r < rn)
            recs[k++] = right[r++];
        left = right = null;
        return recs;
    }


    private static class Rec {
        int index;  // stores the position in array
        int num;    // count how many element is smaller than it on after it.
        public Rec(int index, int num) {
            this.index = index;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        List<Integer> ans = countSmaller(nums);
        System.out.println(ans);
    }
}
