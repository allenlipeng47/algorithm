package com.pli.project.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lipeng on 2016/7/24.
 */
public class l128LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        while (!set.isEmpty()) {
            int num = set.iterator().next();
            set.remove(num);
            int right = num;
            while (set.contains(right + 1)) {
                right++;
                set.remove(right);
            }
            int left = num;
            while (set.contains(left - 1)) {
                left--;
                set.remove(left);
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }


}
