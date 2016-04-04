package com.pli.project.algorithm.recursion;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by lipeng on 2015/11/1.
 */
public class WildCardMatchTest {

    @Test
    public void testCase1(){
        assertTrue(WildCardMatch.matchReg("aa", "aa"));
        assertTrue(WildCardMatch.matchReg("aa", "a*"));
        assertFalse(WildCardMatch.matchReg("aaa", "aa"));
        assertTrue(WildCardMatch.matchReg("aa", ".*"));
        assertTrue(WildCardMatch.matchReg("ab", ".*"));
        assertFalse(WildCardMatch.matchReg("aab", "c*a*b"));
    }

}
