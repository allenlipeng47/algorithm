package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/8/16.
 */
public class GrayCodeTest {

    @Test
    public void test1() {
        GrayCode g = new GrayCode();
        List<Integer> list = g.grayCode(2);
        assert list.get(0) == 0;
        assert list.get(1) == 1;
        assert list.get(2) == 3;
        assert list.get(3) == 2;
        list = g.grayCode(0);
        assert list.get(0) == 0;
        assert list.size() == 1;
    }

}
