package com.pli.project.algorithm.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by lipeng on 2016/1/23.
 * https://leetcode.com/problems/single-number-iii/
 */
public class SingleNumberIII {

    // hashset solution
    public static int[] singleNumber2(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int num : nums) {
            if (hs.contains(num))
                hs.remove(num);
            else
                hs.add(num);
        }
        int[] ans = new int[2];
        int i = 0;
        for (int num : hs) {
            ans[i++] = num;
        }
        return ans;
    }

    // xor solution.
    public static int[] singleNumber(int[] nums) {
        int xor = 0, n = nums.length;
        for (int num : nums)
            xor ^= num;
        int lowBit = xor & (-xor);
        int[] ans = new int[2];
        for (int num : nums) {
            if ((num & lowBit) == 0)
                ans[0] ^= num;
            else
                ans[1] ^= num;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 2};
        System.out.println(Arrays.toString(singleNumber(nums)));
    }
}
