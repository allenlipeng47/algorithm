package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/11.
 */
public class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    public void test1() {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        assert l.lengthOfLongestSubstring("abcabcbb") == 3;
        assert l.lengthOfLongestSubstring("bbbbb") == 1;
        assert l.lengthOfLongestSubstring("pwwkew") == 3;
        assert l.lengthOfLongestSubstring("abcdebghijk") == 9;
    }

}
