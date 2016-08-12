package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by lipeng on 2016/8/11.
 */
public class ProductArrayExceptSelfTest {

    @Test
    public void test1() {
        ProductArrayExceptSelf p = new ProductArrayExceptSelf();
        int[] ans = p.productExceptSelf(new int[] {1, 2, 3, 4});
        assert ans[0] == 24;
        assert ans[1] == 12;
        assert ans[2] == 8;
        assert ans[3] == 6;
    }

}
