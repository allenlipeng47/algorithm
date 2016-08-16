package com.pli.project.algorithm.amz;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/8/16.
 * https://leetcode.com/problems/count-primes/
 * Count the number of prime numbers less than a non-negative number, n.
 * Pay attention it asks the number of prime LESS THAN n. Not saying equal to n.
 */
public class CountPrimes {

    public int countPrimes(int n) {
        boolean[] dp = new boolean[n];
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (dp[i]) {
                continue;
            }
            ans++;
            for (int j = i + i; j < n; j += i) {
                dp[j] = true;
            }
        }
        return ans;
    }

}
