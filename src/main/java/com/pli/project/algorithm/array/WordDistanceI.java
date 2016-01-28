package com.pli.project.algorithm.array;

import javax.swing.plaf.basic.BasicOptionPaneUI;

/**
 * Created by lipeng on 2016/1/27.
 * Given a list of words and two words word1 and word2,
 * return the shortest distance between these two words in the list.
 */
public class WordDistanceI {

    public static int wordDistance(String[] words, String word1, String word2) {
        int i = 0, n = words.length, min = Integer.MAX_VALUE, index = 0;
        while (i < n && !words[i].equals(word1) && !words[i].equals(word2)) {   // find the first index
            index = ++i;
        }
        while (++i < n) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (!words[index].equals(words[i])) {
                    min = Math.min(min, i - index);
                }
                index = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(wordDistance(words, "makes", "makes"));
    }

}
