package com.pli.project.algorithm.leetcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lipeng on 2016/4/4.
 */
public class LongestStrAtMostKDistinctCharTest {

    LongestStrAtMostKDistinctChar l;

    @Before
    public void setup() {
        l = new LongestStrAtMostKDistinctChar();
    }

    @Test
    public void test() {
        assert l.longestStrKDistinct("eceba", 2) == 3;
        assert l.longestStrKDistinct("eceba", 3) == 4;
        assert l.longestStrKDistinct("asdfsag", 3) == 4;
        assert l.longestStrKDistinct("asdfsag", 4) == 6;
        assert l.longestStrKDistinct("asdfsag", 0) == 0;
        assert l.longestStrKDistinct("asdfsag", 1) == 1;
        assert l.longestStrKDistinct("asdfsag", 7) == 7;
        assert l.longestStrKDistinct("asdfsag", 8) == 7;
    }

    @After
    public void tearUp() {
        l = null;
    }

}
