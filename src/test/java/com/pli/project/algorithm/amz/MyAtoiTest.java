package com.pli.project.algorithm.amz;

import org.junit.Test;

/**
 * Created by lipeng on 2016/8/23.
 */
public class MyAtoiTest {

    @Test
    public void test1() {
        MyAtoi m = new MyAtoi();
        assert m.myAtoi("123") == 123;
        assert m.myAtoi("-123") == -123;
        assert m.myAtoi("-1234444444444444444444") == Integer.MIN_VALUE;
        assert m.myAtoi("    010") == 10;
        assert m.myAtoi("-2147483647") == Integer.MIN_VALUE;
    }

}
