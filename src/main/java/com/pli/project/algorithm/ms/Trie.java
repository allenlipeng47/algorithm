package com.pli.project.algorithm.ms;

import java.util.HashSet;

/**
 * Created by lipeng on 2016/3/17.
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
class TrieNode {

    HashSet<String> hs;

    TrieNode[] nodes;

    // Initialize your data structure here.
    public TrieNode() {
        nodes = new TrieNode[26];
        hs = new HashSet<String>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        int len = word.length();
        TrieNode curr = root;
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            if (curr.nodes[ch - 'a'] == null) {
                curr.nodes[ch - 'a'] = new TrieNode();
            }
            curr = curr.nodes[ch - 'a'];
        }
        curr.hs.add(word);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        int len = word.length();
        TrieNode curr = root;
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            if (curr.nodes[ch - 'a'] != null) {
                curr = curr.nodes[ch - 'a'];
            }
            else {
                return false;
            }
        }
        if (curr.hs.contains(word)) {
            return true;
        }
        else {
            return false;
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        TrieNode curr = root;
        for (int i = 0; i < len; i++) {
            char ch = prefix.charAt(i);
            if (curr.nodes[ch - 'a'] != null) {
                curr = curr.nodes[ch - 'a'];
            }
            else {
                return false;
            }
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");