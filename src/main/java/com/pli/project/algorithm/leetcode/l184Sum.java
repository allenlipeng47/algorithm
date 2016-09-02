package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lipeng on 2016/9/1.
 * https://leetcode.com/problems/4sum/
 * The solution is that we outer loop i, j. When i, j are fixed, we loop lo and hi.
 * When we loop i, j, we need to move them until they need a different element.
 * When we move lo, hi, it's the same, we need to move them until a different element.
 */
public class l184Sum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 3) {
            int j = i + 1;
            while (j < nums.length - 2) {
                int lo = j + 1, hi = nums.length - 1;
                while (lo < hi) {
                    int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        while (++lo < hi && nums[lo] == nums[lo - 1]);  // one line technique to move lo until a different element.
                        while (lo < --hi && nums[hi] == nums[hi + 1]);
                    }
                    else if (sum > target) {
                        hi--;
                    }
                    else {
                        lo++;
                    }
                }
                while (++j < nums.length - 2 && nums[j] == nums[j - 1]);
            }
            while (++i < nums.length - 3 && nums[i] == nums[i - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

}
