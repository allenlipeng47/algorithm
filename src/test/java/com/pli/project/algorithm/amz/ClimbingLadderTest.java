package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/21.
 */
public class ClimbingLadderTest {

    @Test
    public void test1() {
        ClimbingLadder c = new ClimbingLadder();
        assert c.climbStairs(3) == 3;
        assert c.climbStairs(4) == 5;
    }

}
