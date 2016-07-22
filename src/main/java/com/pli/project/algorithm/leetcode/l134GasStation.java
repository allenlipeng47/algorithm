package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/7/21.
 * https://leetcode.com/problems/gas-station/
 */
public class l134GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // test see if there is a result.
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
        }
        if (total < 0) {
            return -1;
        }
        // calculate the aggregation until we find a position which the aggregation from it to the end is greater than or equal to 0
        int aggr = 0, ans = 0;
        for (int i = 0; i < gas.length; i++) {
            aggr += gas[i] - cost[i];
            if (aggr < 0) {
                ans = i + 1;
                aggr = 0;
            }
        }
        return ans;
    }


}
