package com.pli.project.algorithm.amz;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lipeng on 2016/8/22.
 * https://discuss.leetcode.com/category/368/flip-game-ii
 */
public class FlipGameIITest {

    @Test
    public void test1() {
        FlipGameII f = new FlipGameII();
        assert f.canWin("++") == true;
        assert f.canWin("+++") == true;
        assert f.canWin("++++") == true;
        assert f.canWin("+++++") == false;
    }

}
