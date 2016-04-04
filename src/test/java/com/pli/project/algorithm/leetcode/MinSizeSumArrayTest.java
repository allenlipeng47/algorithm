package com.pli.project.algorithm.leetcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lipeng on 2016/3/25.
 */
public class MinSizeSumArrayTest {

    MinSizeSumArray m;

    @Before
    public void setUp() {
        m = new MinSizeSumArray();
    }

    @Test
    public void test() {
        int[] nums = {3, 6, 2, 4, 6};
        assert m.minSubArrayLen(9, nums) == 2;
        assert m.minSubArrayLen(7, nums) == 2;
        assert m.minSubArrayLen(5, nums) == 1;
        assert m.minSubArrayLen(15, nums) == 4;
        assert m.minSubArrayLen(30, nums) == 0;

        nums = new int[] {1, 2, 3, 4, 5};
        assert m.minSubArrayLen(11, nums) == 3;
    }

    @After
    public void tearDown() {
        m = null;
    }
}
