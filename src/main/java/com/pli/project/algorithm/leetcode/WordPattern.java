package com.pli.project.algorithm.leetcode;

import java.util.HashMap;

/**
 * Created by lipeng on 2016/1/17.
 * https://leetcode.com/problems/word-pattern/
 * This problem is actually a isomorphic problem
 */
public class WordPattern {

    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        HashMap<Character, String> hmCh = new HashMap<Character, String>();
        HashMap<String, Character> hmWord = new HashMap<String, Character>();
        if(words.length != pattern.length())
            return false;
        for(int i = 0; i < words.length; i++) {
            char ch = pattern.charAt(i);
            if(hmCh.get(ch) == null && hmWord.get(words[i]) == null) {
                hmCh.put(ch, words[i]);
                hmWord.put(words[i], ch);
            }
            else if(hmCh.get(ch) == null || hmWord.get(words[i]) == null)
                return false;
            else if(!words[i].equals(hmCh.get(ch)) || ch != hmWord.get(words[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        System.out.println(wordPattern(pattern, str));
    }

}
