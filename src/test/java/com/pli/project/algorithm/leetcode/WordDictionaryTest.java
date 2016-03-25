package com.pli.project.algorithm.leetcode;

import com.pli.project.algorithm.array.WordDistanceI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lipeng on 2016/3/23.
 */
public class WordDictionaryTest {

    WordDictionary w;

    @Before
    public void setUp() {
        w = new WordDictionary();
    }

    @Test
    public void test1() {
        w.addWord("abcd");
        w.addWord("abc");
        assert w.search("abc") == true;
        assert w.search("abcd") == true;
        assert w.search("ab") == false;
        assert w.search("abcde") == false;
        assert w.search("ab.") == true;
    }

    @Test
    public void test2() {
        w.addWord("a");
        assert w.search(".") == true;
    }

    @After
    public void tearDown() {
        w = null;
    }


}
