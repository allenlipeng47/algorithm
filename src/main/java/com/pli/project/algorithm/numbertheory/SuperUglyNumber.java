package com.pli.project.algorithm.numbertheory;

/**
 * Created by pli on 1/5/2016.
 */
public class SuperUglyNumber {

    public static int nthSuperUglyNumber(int[] primes, int n) {
        int pn = primes.length;
        int[] index = new int[pn];
        int[] nums = new int[n];
        nums[0] = 1;
        for(int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < pn; j++) {
                int curr = nums[index[j]] * primes[j];
                min = curr < min ? curr : min;
            }
            nums[i] = min;
            for(int j = 0; j < pn; j++)
                if(nums[i] == nums[index[j]] * primes[j])
                    index[j]++;
        }
        return nums[n - 1];
    }

}
