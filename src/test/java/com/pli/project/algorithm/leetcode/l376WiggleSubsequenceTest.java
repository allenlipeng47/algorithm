package com.pli.project.algorithm.leetcode;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/29.
 */
public class l376WiggleSubsequenceTest {

    @Test
    public void test1() {
        l376WiggleSubsequence l = new l376WiggleSubsequence();
        assert l.wiggleMaxLength(new int[]{1,7,4,9,2,5}) == 6;
        assert l.wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}) == 7;
        assert l.wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}) == 2;
        assert l.wiggleMaxLength(new int[]{1,1}) == 1;
        assert l.wiggleMaxLength(new int[]{1,1, 1}) == 1;
        assert l.wiggleMaxLength(new int[]{1,2}) == 2;
        assert l.wiggleMaxLength(new int[]{3, 3, 3, 2, 5}) == 3;
    }

}
