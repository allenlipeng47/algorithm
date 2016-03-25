package com.pli.project.algorithm.leetcode;

import com.pli.project.algorithm.test2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by lipeng on 2016/3/24.
 * dfs + trie.
 */
public class WordSearchII {

    Trie trie;

    class Trie {
        Trie[] next = new Trie[26];
        List<String> words = new ArrayList<>();
    }

    private void addWord(Trie trie, String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (trie.next[ch - 'a'] == null) {
                trie.next[ch - 'a'] = new Trie();
            }
            trie = trie.next[ch - 'a'];
        }
        trie.words.add(word);
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length <= 0 || board[0].length <= 0 || words == null || words.length <= 0) {
            return null;
        }
        Trie trie = new Trie();
        for (String word : words) {
           addWord(trie, word);
        }
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                dfs(hs, board, trie, i, j, new boolean[board.length][board[0].length]);
        return new ArrayList<>(hs);
    }

    public void dfs(HashSet<String> ans, char[][] board, Trie trie, int i, int j, boolean[][] used) {
        if (trie == null || i < 0 || i >= board.length || j < 0 || j >= board[0].length
            || used[i][j] || trie.next[board[i][j] - 'a'] == null) {
            return ;
        }
        trie = trie.next[board[i][j] - 'a'];
        if (trie.words.size() > 0) {
            for (String w : trie.words) {
                if (!ans.contains(w)) {
                    ans.add(w);
                }
            }
        }
        used[i][j] = true;
        dfs(ans, board, trie,  i - 1, j, used);
        dfs(ans, board, trie,  i + 1, j, used);
        dfs(ans, board, trie,  i, j - 1, used);
        dfs(ans, board, trie,  i, j + 1, used);
        used[i][j] = false;
    }

    public static void main(String[] args) {
        String[] words = {"oath","pea","eat","rain"};
        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        List<String> ans = new ArrayList<>();
        WordSearchII w = new WordSearchII();
        ans = w.findWords(board, words);
        System.out.println(ans);
    }

}
