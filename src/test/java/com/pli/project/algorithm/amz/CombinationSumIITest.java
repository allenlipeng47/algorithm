package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.List;

/**
 * Created by lipeng on 2016/8/22.
 */
public class CombinationSumIITest {

    @Test
    public void test1() {
        CombinationSumII c = new CombinationSumII();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> ans = c.combinationSum2(candidates, 8);
        System.out.println(ans);
    }

}
