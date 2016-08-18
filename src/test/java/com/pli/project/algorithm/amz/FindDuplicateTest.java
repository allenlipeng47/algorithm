package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/17.
 */
public class FindDuplicateTest {

    @Test
    public void test1() {
        int[] nums = {1, 4, 3, 3, 2};
        FindDuplicate f = new FindDuplicate();
        System.out.println(f.findDuplicate(nums));
    }


}
