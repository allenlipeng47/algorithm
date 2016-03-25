package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by lipeng on 2016/3/24.
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 * dfs + trie.
 */
public class WordDictionary {

    class Trie {
        Trie[] next = new Trie[26];
        String word;
    }

    Trie trie = new Trie();

    public void addWord(String word) {
        Trie curr = trie;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.next[ch - 'a'] == null) {
                curr.next[ch - 'a'] = new Trie();
            }
            curr = curr.next[ch - 'a'];
        }
        curr.word = word;
    }

    public boolean search(String word) {
        return searchHelper(trie, word, 0);
    }

    // If it is '.', iterate all trie.next. Or directly go to next level.
    private boolean searchHelper(Trie trie, String word, int i) {
        if (i >= word.length()) {
            if (trie.word != null) {
                return true;
            }
            else {
                return false;
            }
        }
        char ch = word.charAt(i);
        if (ch != '.') {
            if (trie.next[ch - 'a'] == null) {
                return false;
            }
            return searchHelper(trie.next[ch - 'a'], word, i + 1);
        }
        for (Trie t : trie.next) {
            if (t != null && searchHelper(t, word, i + 1)) {
                return true;
            }
        }
        return false;
    }

}
