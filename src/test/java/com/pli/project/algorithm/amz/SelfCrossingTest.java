package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/20.
 */
public class SelfCrossingTest {

    @Test
    public void test1() {
        SelfCrossing s = new SelfCrossing();
        assert s.isSelfCrossing(new int[] {2, 1, 1, 2}) == true;
        assert s.isSelfCrossing(new int[] {1, 2, 3, 4}) == false;
        assert s.isSelfCrossing(new int[] {1, 1, 1, 1}) == true;
        assert s.isSelfCrossing(new int[] {3, 3, 3, 2, 1, 1}) == false;
        assert s.isSelfCrossing(new int[] {3, 3, 2, 2, 1, 1}) == false;
    }

}
