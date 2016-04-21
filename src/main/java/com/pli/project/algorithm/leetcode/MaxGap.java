package com.pli.project.algorithm.leetcode;

import com.sun.media.sound.RIFFInvalidDataException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by lipeng on 2016/4/20.
 */
public class MaxGap {

    public static int maximumGap(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int bucketNum = nums.length + 1;
        double interval = (double)(max - min) / bucketNum;
        int[] minBucket = new int[bucketNum];
        int[] maxBucket = new int[bucketNum];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        for (int i = 0; i < nums.length; i++) {
            int bucket = (int)((nums[i] - min) / interval);
            bucket = bucket >= minBucket.length ? bucket - 1 : bucket;
            minBucket[bucket] = Math.min(minBucket[bucket], nums[i]);
            maxBucket[bucket] = Math.max(maxBucket[bucket], nums[i]);
        }
        int ans = 0;
        for (int leftBucket = 0, rightBucket = 1; rightBucket < minBucket.length; rightBucket++) {
            if (minBucket[rightBucket] == Integer.MAX_VALUE) {
                continue;
            }
            ans = Math.max(ans, minBucket[rightBucket] - maxBucket[leftBucket]);
            leftBucket = rightBucket;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5, 9, 8, 3, 15};
        int ans = maximumGap(nums);
        System.out.println(ans);
//        ArrayList<Integer> list = new ArrayList<>(5);
//        System.out.println();
    }


}
