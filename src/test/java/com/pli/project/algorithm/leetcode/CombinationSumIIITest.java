package com.pli.project.algorithm.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lipeng on 2016/3/23.
 */
public class CombinationSumIIITest {

    CombinationSumIII c;
    List<List<Integer>> list;

    @Before
    public void setUp() {
        c = new CombinationSumIII();
    }

    @Test
    public void test() {
        list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1, 2, 4)));
        assert c.combinationSum3(3, 7).equals(list);
        list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1, 2, 6)));
        list.add(new ArrayList<>(Arrays.asList(1, 3, 5)));
        list.add(new ArrayList<>(Arrays.asList(2, 3, 4)));
        assert c.combinationSum3(3, 9).equals(list);
    }


}
