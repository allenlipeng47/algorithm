package com.pli.project.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by lipeng on 2016/3/11.
 */
public class PalindromePair2 {

    static class MyWord implements Comparable<MyWord>{
        String str;
        int pos;

        public MyWord(String str, int pos) {
            this.str = str;
            this.pos = pos;
        }

        public int compareTo(MyWord myWord) {
            return str.length() - myWord.str.length();
        }
    }

    static class Trie {
        Trie[] nodes;
        HashSet<Integer> wordPoses;

        public Trie() {
            nodes = new Trie[256];
            wordPoses = new HashSet<>();
        }

        public void add(String str, int pos) {
            int len = str.length();
            Trie trie = this;
            for (int i = 0; i < len; i++) {
                char ch = str.charAt(i);
                if (trie.nodes[ch - '0'] == null) {
                    trie.nodes[ch - '0'] = new Trie();
                }
                trie = trie.nodes[ch - '0'];
            }
            trie.wordPoses.add(pos);
        }   // add

    }   // Trie

    public static List<List<Integer>> palindromePairs(String[] words) {
        MyWord[] myWords = new MyWord[words.length];
        for (int i = 0; i < words.length; i++) {
            myWords[i] = new MyWord(words[i], i);
        }
        Arrays.sort(myWords);
        List<List<Integer>> ans = new ArrayList<>();
        Trie orderTrie = new Trie();
        Trie reverseOrderTrie = new Trie();
        for (MyWord myWord : myWords) {
            int strLen = myWord.str.length();
            // check in orderTrie
            int i = strLen - 1;
            Trie trie = orderTrie;
            char ch;
            while (i >= 0 && trie.nodes[(ch = myWord.str.charAt(i)) - '0'] != null) {
                if (trie.wordPoses.size() >= 0 && isPalindrome(myWord.str, 0, i - 1)) {    // the end is a word and rest of str is palindrome
                    for (int triePos : trie.wordPoses) {
                        ans.add(new ArrayList<Integer>(Arrays.asList(triePos, myWord.pos)));
                    }
                }
                trie = trie.nodes[ch - '0'];
                i--;
            }
            // check in reverseOrderTrie
            i = 0;
            trie = reverseOrderTrie;
            while (i < myWord.str.length() && trie.nodes[(ch = myWord.str.charAt(i)) - '0'] != null) {
                if (trie.wordPoses.size() >= 0 && isPalindrome(myWord.str, i, strLen - 1)) {
                    for (int triePos : trie.wordPoses) {
                        ans.add(new ArrayList<Integer>(Arrays.asList(myWord.pos, triePos)));
                    }
                }
                trie = trie.nodes[ch - '0'];
                i++;
            }

            orderTrie.add(myWord.str, myWord.pos);
            reverseOrderTrie.add(new StringBuffer(myWord.str).reverse().toString(), myWord.pos);
        }
        return ans;

    }

    public static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
//        String[] words = {"bat", "tab", "cat"};
//        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
//        String[] words = {"lls", "s"};
        String[] words = {"a","abc","aba",""};
//        String[] words = {"aba", ""};
//        String[] words = {"aba",""};
        List<List<Integer>> ans = palindromePairs(words);
        System.out.println(ans);
    }



}
