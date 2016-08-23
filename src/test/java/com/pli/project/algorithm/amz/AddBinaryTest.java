package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/22.
 */
public class AddBinaryTest {

    @Test
    public void test1() {
        AddBinary a = new AddBinary();
        assert a.addBinary("11", "1").equals("100");
    }

}
