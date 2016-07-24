package com.pli.project.algorithm.leetcode;

import java.util.*;

/**
 * Created by lipeng on 2016/7/24.
 * https://leetcode.com/problems/word-ladder/
 * BFS solution, without building graph. When adding a word's neighbor, should iterate word variation.
 * Instead of iterating all wordList.
 */
public class l127WordLadder {

    // BFS solution
    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        queue.addAll(getList(beginWord, wordList, visited));
        wordList.add(endWord);
        int ans = 1;
        while (!queue.isEmpty()) {
            ans++;
            LinkedList<String> second = new LinkedList<>();
            while (!queue.isEmpty()) {  // get neighbors of all elements in queue
                String curr = queue.removeLast();
                if (curr.equals(endWord)) {
                    return ans;
                }
                second.addAll(getList(curr, wordList, visited));
            }
            queue = second;
        }
        return 0;
    }

    private static List<String> getList(String beginWord, Set<String> wordList, Set<String> visited) {
        LinkedList<String> list = new LinkedList<>();
        char[] chs = beginWord.toCharArray();   // Instead of iterate all the wordList, iterate the variation of word. This makes time shorter!!
        for (int i = 0; i < chs.length; i++) {
            char old = chs[i];
            for (char c = 'a'; c <= 'z'; c++) {
                chs[i] = c;
                String curr = String.valueOf(chs);
                if (wordList.contains(curr) && !visited.contains(curr)) {
                    list.add(curr);
                    visited.add(curr);
                }
            }
            chs[i] = old;
        }
        return list;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        Set<String> wordList = new HashSet<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

}
