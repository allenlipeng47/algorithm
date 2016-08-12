package com.pli.project.algorithm.amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lipeng on 2016/8/11.
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }
                else if (sum < 0) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return list;
    }

    // considering skip the duplicates.
    public List<List<Integer>> threeSumWithDuplicate(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
                else if (sum < 0) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return list;
    }

}
