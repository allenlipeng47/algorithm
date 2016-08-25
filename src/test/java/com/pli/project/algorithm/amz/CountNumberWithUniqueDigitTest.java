package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/24.
 */
public class CountNumberWithUniqueDigitTest {

    @Test
    public void test1() {
        CountNumberWithUniqueDigit c = new CountNumberWithUniqueDigit();
        assert c.countNumbersWithUniqueDigits(0) == 1;
        assert c.countNumbersWithUniqueDigits(1) == 10;
        assert c.countNumbersWithUniqueDigits(2) == 91;
        assert c.countNumbersWithUniqueDigits(3) == 739;
    }

}
