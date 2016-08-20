package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/20.
 */
public class ReverseIntegerTest {

    @Test
    public void test1() {
        ReverseInteger r = new ReverseInteger();
        assert r.reverse(123) == 321;
        assert r.reverse(-123) == -321;
        assert r.reverse(1534236469) == 0;
    }


}
