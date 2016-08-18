package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/8/16.
 */
public class MoveZerosTest {

    @Test
    public void test1() {
        int[] nums = {0, 1, 0, 3, 12};
        MoveZeros m = new MoveZeros();
        m.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
