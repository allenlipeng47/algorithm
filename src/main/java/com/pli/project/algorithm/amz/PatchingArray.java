package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/19.
 */
public class PatchingArray {

    public int minPatches(int[] nums, int n) {
        long reach = 0;
        int i = 0, ans = 0;
        while (reach < n) {
            if (i < nums.length && reach + 1 >= nums[i]) {
                reach += nums[i];
                i++;
            }
            else {
                ans++;
                reach = reach * 2 + 1;
            }
        }
        return ans;
    }

}
