package com.pli.project.algorithm.practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lipeng on 2016/8/10.
 */
public class WordLadderTest {

    @Test
    public void test1() {
        WordLadder w = new WordLadder();
        Set<String> wordList = new HashSet<>();
        wordList.add("hot");
        wordList.add("dot");// ,"dog","lot","log"
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        Set<String> visited = new HashSet<>();
        assert w.getList(wordList, visited, "hit").contains("hot");
    }

    @Test
    public void test2() {
        WordLadder w = new WordLadder();
        Set<String> wordList = new HashSet<>();
        wordList.add("hot");
        wordList.add("dot");// ,"dog","lot","log"
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        assert w.ladderLength("hit", "cog", wordList) == 5;
    }
}
