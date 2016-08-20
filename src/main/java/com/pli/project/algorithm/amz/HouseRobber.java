package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/20.
 */
public class HouseRobber {

    public int rob2(int[] nums) {
        int[] maxRob = new int[nums.length + 2], max = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            maxRob[i + 2] = nums[i] + max[i];
            max[i + 2] = Math.max(maxRob[i + 2], max[i + 1]);
        }
        return max[nums.length + 1];
    }

    public int rob(int[] nums) {
        int rob = 0, noRob = 0;
        for (int i : nums) {
            int preRob = rob, preNoRob = noRob;
            rob = i + preNoRob;
            noRob = Math.max(preRob, preNoRob);
        }
        return Math.max(rob, noRob);
    }

}
