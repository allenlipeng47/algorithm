package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/21.
 */
public class RemoveDupFromSlIITest {

    @Test
    public void test1() {
        RemoveDupFromSlII r = new RemoveDupFromSlII();
        int[] nums = {1, 1, 1, 2, 2, 3};
        assert r.removeDuplicates(nums) == 5;
        assert nums[0] == 1;
        assert nums[1] == 1;
        assert nums[2] == 2;
        assert nums[3] == 2;
        assert nums[4] == 3;
    }


    @Test
    public void test2() {
        RemoveDupFromSlII r = new RemoveDupFromSlII();
        int[] nums = {1, 1, 1};
        assert r.removeDuplicates(nums) == 2;
        assert nums[0] == 1;
        assert nums[1] == 1;
    }

}
