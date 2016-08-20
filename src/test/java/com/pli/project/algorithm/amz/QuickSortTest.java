package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/20.
 */
public class QuickSortTest {

    @Test
    public void test1() {
        int[] nums = {5, 3, 1, 4, 2};
        QuickSort q = new QuickSort();
        q.quickSort(nums);
        assert nums[0] == 1;
        assert nums[1] == 2;
        assert nums[2] == 3;
        assert nums[3] == 4;
        assert nums[4] == 5;
    }

}
