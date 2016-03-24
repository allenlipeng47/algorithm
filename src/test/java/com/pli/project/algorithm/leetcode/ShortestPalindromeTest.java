package com.pli.project.algorithm.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lipeng on 2016/3/23.
 */
public class ShortestPalindromeTest {

    ShortestPalindrome s;

    @Before
    public void setUp() {
        s = new ShortestPalindrome();
    }

    @Test
    public void test() {
        assert s.shortestPalindrome("").equals("");
        assert s.shortestPalindrome("aacecaaa").equals("aaacecaaa");
        assert s.shortestPalindrome("abcd").equals("dcbabcd");
    }


}
