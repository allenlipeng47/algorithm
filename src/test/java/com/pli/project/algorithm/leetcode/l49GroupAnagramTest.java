package com.pli.project.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lipeng on 2016/8/12.
 */
public class l49GroupAnagramTest {

    @Test
    public void test1() {
        l49GroupAnagram l = new l49GroupAnagram();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(l.groupAnagrams(strs));
    }

}
