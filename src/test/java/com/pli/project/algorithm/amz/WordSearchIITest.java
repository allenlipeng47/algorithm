package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.leetcode.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lipeng on 2016/8/20.
 */
public class WordSearchIITest {

    @Test
    public void test1() {
        String[] words = {"oath","pea","eat","rain"};
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        WordSearchII w = new WordSearchII();
        List<String> ans = w.findWords(board, words);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        String[] words = {"a"};
        char[][] board = null;
        WordSearchII w = new WordSearchII();
        List<String> ans = w.findWords(board, words);
        System.out.println(ans);
    }
}
