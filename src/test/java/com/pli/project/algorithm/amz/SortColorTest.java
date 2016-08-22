package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/8/21.
 */
public class SortColorTest {

    @Test
    public void test1() {
        SortColors s = new SortColors();
        int[] nums = {2, 2, 2, 1, 1, 1, 0, 0, 1, 2};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
