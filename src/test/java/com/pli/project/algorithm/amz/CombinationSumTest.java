package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/8/22.
 */
public class CombinationSumTest {

    @Test
    public void test1() {
        CombinationSum c = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> set = c.combinationSum(candidates, 7);
        System.out.println(set);
    }
}
