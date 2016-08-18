package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/17.
 */
public class VerifyPreorderSerializationTest {

    @Test
    public void test() {
        VerifyPreorderSerialization v = new VerifyPreorderSerialization();
        assert v.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#") == true;
    }
}
