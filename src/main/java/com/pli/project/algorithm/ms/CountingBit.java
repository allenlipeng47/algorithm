package com.pli.project.algorithm.ms;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/3/19.
 */
public class CountingBit {

    public int[] countBits(int num) {
        num++;
        int[] ans = new int[num];
        for (int i = 1; i < num; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountingBit count = new CountingBit();
        System.out.println(Arrays.toString(count.countBits(5)));
    }


}
