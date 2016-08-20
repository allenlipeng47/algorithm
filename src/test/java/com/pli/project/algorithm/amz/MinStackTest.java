package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by lipeng on 2016/8/11.
 * https://leetcode.com/problems/min-stack/
 */
public class MinStackTest {

    @Test
    public void test1() {
        MinStack m = new MinStack();
        m.push(5);
        assert m.min == 5;
        m.push(4);
        assert m.min == 4;
        m.push(6);
        assert m.min == 4;
        m.push(1);
        assert m.min == 1;
        m.push(3);
        assert m.min == 1;
        m.pop();
        assert m.min == 1;
        m.pop();
        assert m.min == 4;
        m.pop();
        assert m.min == 4;
    }


}
