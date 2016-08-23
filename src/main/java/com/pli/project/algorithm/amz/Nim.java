package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/22.
 * https://leetcode.com/problems/nim-game/
 * http://www.allenlipeng47.com/blog/index.php/2016/01/16/study-summaries-for-game-theory/
 */
public class Nim {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

}
