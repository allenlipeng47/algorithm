package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/20.
 */
public class HouseRobberTest {

    @Test
    public void test1() {
        HouseRobber h = new HouseRobber();
        assert h.rob(new int[]{0}) == 0;
        assert h.rob(new int[]{1, 1, 1}) == 2;
    }

}
