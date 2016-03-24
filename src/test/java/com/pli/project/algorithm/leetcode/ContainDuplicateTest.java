package com.pli.project.algorithm.leetcode;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by lipeng on 2016/3/23.
 */
public class ContainDuplicateTest {

    ContainDuplicate c;

    @Before
    public void setUp() {
        c = new ContainDuplicate();
    }

    @Test
    public void test() {
        assert c.containsDuplicate(null) == false;
        assert c.containsDuplicate(new int[] {1}) == false;
        assert c.containsDuplicate(new int[] {1, 1}) == true;
        assert c.containsDuplicate(new int[] {1, 2, 1}) == true;
        assert c.containsDuplicate(new int[] {1, 2, 3}) == false;
    }


}
