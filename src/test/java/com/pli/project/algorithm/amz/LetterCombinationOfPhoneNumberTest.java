package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lipeng on 2016/8/10.
 */
public class LetterCombinationOfPhoneNumberTest {

    @Test
    public void test1() {
        LetterCombinationOfPhoneNumber l = new LetterCombinationOfPhoneNumber();
        List<String> list = l.letterCombinations("234");
        assert list.contains("adg");
        assert list.contains("afg");
        assert list.contains("cfi");
        assert list.contains("bdi");
        System.out.println(list);
    }

}
