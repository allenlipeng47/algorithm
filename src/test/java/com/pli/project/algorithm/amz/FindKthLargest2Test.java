package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/20.
 */
public class FindKthLargest2Test {

    @Test
    public void test1() {
        int[] nums = {4, 3, 2, 5, 1};
        FindKthLargest2 f = new FindKthLargest2();
        assert f.findKthLargest(nums, 1) == 5;
        assert f.findKthLargest(nums, 2) == 4;
        assert f.findKthLargest(nums, 4) == 2;
    }

}
