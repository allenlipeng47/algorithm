package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lipeng on 2016/8/22.
 */
public class RomanToIntTest {

    @Test
    public void test1() {
        RomanToInt r = new RomanToInt();
        assert r.romanToInt("DCXXI") == 621;
    }

}
