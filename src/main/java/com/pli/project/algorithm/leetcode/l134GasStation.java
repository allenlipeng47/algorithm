package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/7/21.
 * https://leetcode.com/problems/gas-station/
 */
public class l134GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
        }
        if (total < 0) {
            return -1;
        }
        int net = 0, ans = 0;
        for (int i = 0; i < gas.length; i++) {
            net += gas[i] - cost[i];
            if (net < 0) {
                ans = i + 1;
                net = 0;
            }
        }
        return ans;
    }


}
