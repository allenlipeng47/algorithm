package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lipeng on 2016/8/20.
 */
public class LongestSubstringAtMostKDiffTest {

    @Test
    public void test1() {
        LongestSubstringAtMostKDiff l = new LongestSubstringAtMostKDiff();
        assert l.getLongest("acccddee", 2) == 5;
        assert l.getLongest("acccddee", 3) == 7;
        assert l.getLongest("aacccddee", 4) == 9;
        assert l.getLongest("", 4) == 0;
        assert l.getLongest("a", 4) == 1;
    }
}
