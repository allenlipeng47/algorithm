package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/10.
 */
public class TrappingRainWaterTest {

    @Test
    public void test1() {
        TrappingRainWater t = new TrappingRainWater();
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        assert t.trap(nums) == 6;
    }
}
