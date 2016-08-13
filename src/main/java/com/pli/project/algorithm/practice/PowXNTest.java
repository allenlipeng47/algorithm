package com.pli.project.algorithm.practice;

import com.pli.project.algorithm.leetcode.PowXN;
import org.junit.Test;

/**
 * Created by lipeng on 2016/8/12.
 * https://leetcode.com/problems/powx-n/
 */
public class PowXNTest {

    @Test
    public void test1() {
        PowXN p = new PowXN();
//        assert p.myPow(4, 3) == 64;
//        assert p.myPow(8, 3) == 512;
        System.out.println(p.myPow(8.88023, 3));
        assert p.myPow(8.88023, 3) == 700.28148;
    }


}
