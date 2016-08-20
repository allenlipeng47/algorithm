package com.pli.project.algorithm.amz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lipeng on 2016/8/20.
 */
public class WordSearchII {

    class Trie {
        public Trie[] nodes = new Trie[26];
        public String word;

        public void addWord(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (trie.nodes[ch - 'a'] == null) {
                    trie.nodes[ch - 'a'] = new Trie();
                }
                trie = trie.nodes[ch - 'a'];
            }
            trie.word = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return new ArrayList<String>();
        }
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trie, new boolean[board.length][board[0].length], ans);
            }
        }
        return new ArrayList(ans);
    }

    private void dfs(char[][] board, int i, int j, Trie trie, boolean[][] visited, Set<String> ans) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || visited[i][j] || trie.nodes[board[i][j] - 'a'] == null) {
            return;
        }
        trie = trie.nodes[board[i][j] - 'a'];
        if (trie.word != null) {
            ans.add(trie.word);
        }
        visited[i][j] = true;
        dfs(board, i - 1, j, trie, visited, ans);
        dfs(board, i + 1, j, trie, visited, ans);
        dfs(board, i, j - 1, trie, visited, ans);
        dfs(board, i, j + 1, trie, visited, ans);
        visited[i][j] = false;
    }
}
