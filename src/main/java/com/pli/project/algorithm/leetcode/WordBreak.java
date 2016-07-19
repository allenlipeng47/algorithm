package com.pli.project.algorithm.leetcode;

import java.util.Set;

/**
 * Created by lipeng on 2016/7/18.
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> wordDict) {
        s = " " + s;
        boolean[] mem = new boolean[s.length()];
        int len = mem.length;
        mem[0] = true;
        for (int i = 1; i < len; i++) {
            if (mem[i - 1]) {
                for (String word : wordDict) {
                    if (i + word.length() <= len && s.substring(i, i + word.length()).equals(word)) {
                        mem[i + word.length() - 1] = true;
                    }
                }
            }
        }
        return mem[len - 1];
    }



}
