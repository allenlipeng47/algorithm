package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by lipeng on 2016/3/24.
 * https://leetcode.com/problems/word-search-ii/
 * This is the naive way. For each position, try each word.
 */
public class WordSearchIINaive {

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length <= 0 || board[0].length <= 0 || words == null || words.length <= 0) {
            return null;
        }
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                for (String word : words)
                    if (!hs.contains(word))
                        dfs(hs, board, word, 0, i, j, new boolean[board.length][board[0].length]);
        return new ArrayList<>(hs);
    }

    public void dfs(HashSet<String> ans, char[][] board, String word, int pos, int i, int j, boolean[][] used) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || used[i][j]
                || (pos < word.length() && word.charAt(pos) != board[i][j]) || ans.contains(word)) {
            return ;
        }
        if (pos >= word.length() - 1) {
            ans.add(word);
            return;
        }
        used[i][j] = true;
        dfs(ans, board, word, pos + 1, i - 1, j, used);
        dfs(ans, board, word, pos + 1, i + 1, j, used);
        dfs(ans, board, word, pos + 1, i, j - 1, used);
        dfs(ans, board, word, pos + 1, i, j + 1, used);
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
        WordSearchIINaive w = new WordSearchIINaive();
        ans = w.findWords(board, words);
        System.out.println(ans);
    }

}
