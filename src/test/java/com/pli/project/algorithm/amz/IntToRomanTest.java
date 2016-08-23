package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by lipeng on 2016/8/22.
 * https://leetcode.com/problems/integer-to-roman/
 */
public class IntToRomanTest {

    @Test
    public void test1() {
        IntToRoman i = new IntToRoman();
        assert i.intToRoman(621).equals("DCXXI");
    }

}
