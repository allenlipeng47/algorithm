package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/19.
 */
public class CountDigitOneTest {

    @Test
    public void test1() {
        CountDigitOne c = new CountDigitOne();
        assert c.countDigitOne(2) == 1;
        assert c.countDigitOne(10) == 2;
        assert c.countDigitOne(11) == 4;
        assert c.countDigitOne(1410065408) == 1737167499;
    }

}
