package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lipeng on 2016/8/11.
 */
public class WordBreakTest {

    @Test
    public void test1() {
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("code");
        WordBreak w = new WordBreak();
        assert w.wordBreak("leetcode", dict) == true;
    }

    @Test
    public void test2() {
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("sat");
        dict.add("to");
        WordBreak w = new WordBreak();
        assert w.wordBreak("catsatto", dict) == true;
    }

}
