package com.pli.project.algorithm.practice;

import com.pli.project.algorithm.tree.BinaryIndexedTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2015/12/12.
 */
public class BinarySearchTest {

    @Test
    public void test1() {
        BinarySearch b = new BinarySearch();
        int[] nums = {1, 2, 3, 5, 6};
        assert b.findLeftInclusive(nums, 3) == 2;
        assert b.findLeftInclusive(nums, 4) == 2;
        assert b.findLeftInclusive(nums, 1) == 0;
        assert b.findLeftInclusive(nums, 0) == -1;
        assert b.findLeftInclusive(nums, 6) == 4;
        assert b.findLeftInclusive(nums, 7) == 4;
    }


}