package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/23.
 */
public class ReverseWordInStringTest {

    @Test
    public void test1() {
        ReverseWordInString r = new ReverseWordInString();
        System.out.println(r.reverseWords("the sky is blue"));
        assert r.reverseWords("the sky is blue").equals("blue is sky the");
        assert r.reverseWords(" ").equals("");
    }


}
