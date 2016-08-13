package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/8/12.
 */
public class NutsAndBoltsMatchTest {

    @Test
    public void test1() {
        NutsAndBoltsMatch n = new NutsAndBoltsMatch();
        int[] bolts = {4, 3, 2, 1, 6, 5};
        int[] nuts = {2, 5, 6, 4, 1, 3};
        n.nutsBolts(bolts, nuts);
        System.out.println(Arrays.toString(bolts));
        System.out.println(Arrays.toString(nuts));
        for (int i = 0; i < bolts.length; i++) {
            assert bolts[i] == nuts[i];
        }
    }


}