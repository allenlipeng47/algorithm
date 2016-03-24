package com.pli.project.algorithm.leetcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lipeng on 2016/3/22.
 */
public class ContainDuplicateIIITest {


    ContainDuplicateIII c;

    @Before
    public void setUp() {
        c = new ContainDuplicateIII();
    }

    @Test
    public void test1() {
        assert c.containsNearbyAlmostDuplicate(new int[] {1}, 1, 0) == false;
        assert c.containsNearbyAlmostDuplicate(new int[] {}, 1, 0) == false;
        assert c.containsNearbyAlmostDuplicate(new int[] {1, 2}, 1, 1) == true;
        assert c.containsNearbyAlmostDuplicate(new int[] {1, 2}, 1, 1) == true;
        assert c.containsNearbyAlmostDuplicate(new int[] {1, 3}, 1, 1) == false;
        assert c.containsNearbyAlmostDuplicate(new int[] {1, 10, 2}, 1, 2) == false;
        assert c.containsNearbyAlmostDuplicate(new int[] {2, 1}, 1, 1) == true;
        assert c.containsNearbyAlmostDuplicate(new int[] {-1, -1}, 1, 0) == true;
        assert c.containsNearbyAlmostDuplicate(new int[] {2, 0, -2, 2}, 2, 1) == false;
        assert c.containsNearbyAlmostDuplicate(new int[] {-1, 2147483647}, 1, 2147483647) == false;
    }


    public void wrongOne(){
        assert c.containsNearbyAlmostDuplicate(new int[] {}, 1, 1) == false;
        assert c.containsNearbyAlmostDuplicate(null, 1, 1) == false;
        assert c.containsNearbyAlmostDuplicate(new int[] {1, 2, 3, 4, 5, 6}, 3, 3) == true;
        assert c.containsNearbyAlmostDuplicate(new int[] {1, 2, 3, 4, 5, 6}, 2, 3) == true;
        assert c.containsNearbyAlmostDuplicate(new int[] {1, 2, 3, 4, 5, 6}, 0, 3) == false;
        assert c.containsNearbyAlmostDuplicate(new int[] {1, 2, 3, 4, 5, 6}, 2, 0) == false;
        assert c.containsNearbyAlmostDuplicate(new int[] {1, 1}, 5, 5) == true;
        assert c.containsNearbyAlmostDuplicate(new int[] {2, 4}, 1, 2) == true;
        assert c.containsNearbyAlmostDuplicate(new int[] {2, 5, 8}, 2, 1) == false;
        assert c.containsNearbyAlmostDuplicate(new int[] {3, 3, 3}, 1, 1) == true;
        assert c.containsNearbyAlmostDuplicate(new int[] {1, 3, 1}, 2, 1) == true;
    }

    @After
    public void tearDown() {
        c = null;
    }

}
