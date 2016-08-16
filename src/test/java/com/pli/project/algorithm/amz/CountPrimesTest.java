package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/8/16.
 * https://leetcode.com/problems/count-primes/
 */
public class CountPrimesTest {

    @Test
    public void test1() {
        CountPrimes c = new CountPrimes();
        assert c.countPrimes(3) == 1;
        assert c.countPrimes(2) == 0;
        assert c.countPrimes(3) == 1;
        assert c.countPrimes(6) == 3;
        assert c.countPrimes(7) == 3;
    }

}
