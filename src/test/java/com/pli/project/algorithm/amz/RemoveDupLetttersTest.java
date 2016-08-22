package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by lipeng on 2016/8/21.
 */
public class RemoveDupLetttersTest {

    @Test
    public void test1() {
        RemoveDupLettters r = new RemoveDupLettters();
        System.out.println(r.removeDuplicateLetters("bcabc"));
        assert r.removeDuplicateLetters("bcabc").equals("abc");
        assert r.removeDuplicateLetters("cbacdcbc").equals("acdb");
        assert r.removeDuplicateLetters("bbcaac").equals("bac");
    }

}
