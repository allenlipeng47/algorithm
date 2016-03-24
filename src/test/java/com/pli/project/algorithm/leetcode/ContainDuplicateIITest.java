package com.pli.project.algorithm.leetcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lipeng on 2016/3/22.
 */
public class ContainDuplicateIITest {


    ContainDuplicateII c;

    @Before
    public void setUp() {
        c = new ContainDuplicateII();
    }

    @Test
    public void test() {
        assert c.containsNearbyDuplicate(new int[]{1, 2, 3, 4, 2, 0}, 3) == true;
        assert c.containsNearbyDuplicate(new int[]{1, 2, 3, 5, 4, 2, 0}, 3) == false;
        assert c.containsNearbyDuplicate(new int[]{2, 2, 1, 3, 4, 5}, 1) == true;
        assert c.containsNearbyDuplicate(new int[]{2, 1, 3, 4, 5}, 1) == false;
        assert c.containsNearbyDuplicate(new int[]{1}, 2) == false;
        assert c.containsNearbyDuplicate(null, 1) == false;
    }


    // wrong ... Misunderstood that it asks for value difference is less than k.
    public void wrongCase() {
        assert c.containsNearbyDuplicate(new int[]{}, 2) == false;
        assert c.containsNearbyDuplicate(null, 2) == false;
        assert c.containsNearbyDuplicate(new int[]{1, 3, 5}, 2) == true;
        assert c.containsNearbyDuplicate(new int[] {1, 3, 5}, 1) == false;
        assert c.containsNearbyDuplicate(new int[] {1, 3, 3}, 0) == true;
        assert c.containsNearbyDuplicate(new int[] {-3, 0, 3}, 3) == true;
        assert c.containsNearbyDuplicate(new int[] {-3, 0, 3}, 2) == false;
        assert c.containsNearbyDuplicate(new int[] {1, 2}, 2) == false;
    }


    @After
    public void tearDown() {
        c = null;
    }

}
