package com.pli.project.algorithm.practice;

/**
 * Created by lipeng on 2016/9/8.
 * https://leetcode.com/problems/patching-array/
 */
public class PatchingArray {

    public int minPatches(int[] nums, int n) {
        int ans = 0, i = 0;
        long reach = 0;
        while (reach < n){
            if (i < nums.length && reach + 1 >= nums[i]) {
                reach += nums[i++];
            }
            else {
                reach += reach + 1;
                ans++;
            }
        }
        return ans;
    }

}
