package com.pli.project.algorithm.array;

import java.util.HashMap;

/**
 * Created by lipeng on 2016/1/10.
 * http://buttercola.blogspot.com/2016/01/leetcode-maximum-size-subarray-sum.html
 * Given an array nums and a target val k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 Example 1:
 Given nums = [1, -1, 5, -2, 3], k = 3,
 return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 Example 2:
 Given nums = [-2, -1, 2, 1], k = 1,
 return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

 Solution:
 So we can first calculate the prefix sum of each number, so sum(i, j) = sum(j) - sum(i - 1) = k.
 Therefore, for each sum(j), we only need to check if there was a sum(i - 1) which equals to sum(j) - k.
 We can use a hash map to store the previous calculated sum.

 */
public class MaxSubarrayWithSumK {

    public static int getMaxLength(int[] num, int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // <sum, i>, sum of [0,...,i] is sum
        int longest = 0;
        for(int j = 0, sum = num[0]; j < num.length; j++) {
            sum += num[j];
            Integer i = null;
            if((i = hm.get(sum - k)) != null && j - i > longest)
                longest = j - i + 1;
            if(!hm.containsKey(sum))
                hm.put(sum, j);
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3}; int k = 3;
        System.out.println(getMaxLength(nums, k));
    }
}
