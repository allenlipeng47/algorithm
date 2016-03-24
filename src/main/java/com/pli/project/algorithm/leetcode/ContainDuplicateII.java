package com.pli.project.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by lipeng on 2016/3/23.
 */
public class ContainDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                hs.remove(nums[i - k - 1]);
            }
            if (hs.contains(nums[i])) {
                return true;
            }
            hs.add(nums[i]);
        }
        return false;
    }

    // wrong ... Misunderstood that it asks for value difference is less than k.
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k <= 0) {
            return false;
        }
        long size = (long)k + 1;
        HashMap<Long, Long> hm = new HashMap<>();
        for (int i : nums) {
            long bucket = ((long)i - Integer.MIN_VALUE) / size;
            if (hm.containsKey(bucket) || hm.containsKey(bucket - 1) && (long)i - hm.get(bucket - 1) <= k
                    || hm.containsKey(bucket + 1) && hm.get(bucket + 1) - i <= k) {
                return true;
            }
            hm.put(bucket, (long)i);
        }
        return false;
    }


}
