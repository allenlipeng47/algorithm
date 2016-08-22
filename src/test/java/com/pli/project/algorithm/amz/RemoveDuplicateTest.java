package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/21.
 */
public class RemoveDuplicateTest {

    @Test
    public void test1() {
        RemoveDuplicate r = new RemoveDuplicate();
        int[] nums = {1, 1, 2};
        assert r.removeDuplicates(nums) == 2;
        assert nums[0] == 1;
        assert nums[1] == 2;
    }
}
