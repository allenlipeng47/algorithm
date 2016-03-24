package com.pli.project.algorithm.leetcode;

import java.util.HashSet;

/**
 * Created by lipeng on 2016/3/23.
 */
public class ContainDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int i : nums) {
            if (hs.contains(i)) {
                return true;
            }
            hs.add(i);
        }
        return false;
    }


}
