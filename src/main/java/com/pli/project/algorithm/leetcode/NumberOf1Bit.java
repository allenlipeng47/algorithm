package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/4/10.
 */
public class NumberOf1Bit {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n = n & (n - 1);
            ans++;
        }
        return ans;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        for (;n!=0;n = n & (n-1))
            count++;
        return count;
    }

    public static void main(String[] args) {
//        NumberOf1Bit n = new NumberOf1Bit();
//        System.out.println(n.hammingWeight(-6));
        System.out.println(-6 >>> 4);
    }


}
