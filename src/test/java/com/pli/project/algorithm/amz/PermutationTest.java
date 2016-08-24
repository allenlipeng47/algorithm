package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/8/23.
 */
public class PermutationTest {

    @Test
    public void test1() {
        Permutation p = new Permutation();
        List<List<Integer>> list = p.permute(new int[]{1, 2, 3});
        System.out.println(list);
    }

}
