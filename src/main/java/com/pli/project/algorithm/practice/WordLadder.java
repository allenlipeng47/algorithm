package com.pli.project.algorithm.practice;

import java.util.*;

/**
 * Created by lipeng on 2016/8/10.
 * https://leetcode.com/problems/word-ladder/
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        List<String> list = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        wordList.add(endWord);
        int ans = 2;
        list.addAll(getList(wordList, visited, beginWord));
        while (!list.isEmpty()) {
            List<String> list2 = new ArrayList<>();
            for (String word : list) {
                if (word.equals(endWord)) {
                    return ans;
                }
                list2.addAll(getList(wordList, visited, word));
            }
            list = list2;
            ans++;
        }
        return -1;
    }

    public List<String> getList(Set<String> wordList, Set<String> visited, String word) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] chs = word.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == word.charAt(i)) {
                    continue;
                }
                chs[i] = ch;
                String curr = String.valueOf(chs);
                if (!visited.contains(curr) && wordList.contains(curr)) {
                    visited.add(curr);
                    list.add(curr);
                }
            }
        }
        return list;
    }

}
