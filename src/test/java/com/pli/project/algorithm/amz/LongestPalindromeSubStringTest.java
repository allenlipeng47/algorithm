package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/10.
 */
public class LongestPalindromeSubStringTest {

    @Test
    public void test1() {
        LongestPalindromeSubString l = new LongestPalindromeSubString();
        assert l.longestPalindrome("a").equals("a");
        assert l.longestPalindrome("abba").equals("abba");
        assert l.longestPalindrome("abbaa").equals("abba");
        assert l.longestPalindrome("ababaa").equals("ababa");
    }
}
