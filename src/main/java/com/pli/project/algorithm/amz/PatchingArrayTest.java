package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/19.
 */
public class PatchingArrayTest {

    @Test
    public void test1() {
        PatchingArray p = new PatchingArray();
        assert p.minPatches(new int[]{1, 5, 10}, 20) == 2;
        assert p.minPatches(new int[]{1, 2, 2}, 5) == 0;
        assert p.minPatches(new int[]{1, 3}, 6) == 1;
        System.out.println(p.minPatches(new int[]{1, 2, 1}, 5));
    }

}
