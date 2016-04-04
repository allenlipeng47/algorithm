package com.pli.project.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lipeng on 2016/1/27.
 * Given a list of words and two words word1 and word2,
 * return the shortest distance between these two words in the list.
 * But the getDistance() function will be called many times.
 * The design is that for each word, build a List. It stores the position where this word exist in array.
 * The finding process is the same as MinDistanceIn2List
 *
 */
public class WordDistanceII {

    HashMap<String, ArrayList<Integer>> hm;

    public WordDistanceII(String[] words) {
        hm = new HashMap<String, ArrayList<Integer>>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            List list = hm.get(word);
            if (list == null) {
                hm.put(word, new ArrayList<Integer>(Arrays.asList(i)));
            }
            else {
                list.add(i);
            }
        }
    }

    public int getDistance(String word1, String word2) {
        List<Integer> l1 = hm.get(word1);
        List<Integer> l2 = hm.get(word2);
        if (l1 ==null || l2 == null) {
            return Integer.MAX_VALUE;
        }
        int i = 0, j = 0, n = l1.size(), m = l2.size(), min = Integer.MAX_VALUE;
        while (i < n && j < m) {
            int idx1 = l1.get(i), idx2 = l2.get(j);
            min = Math.min(min, Math.abs(idx1 - idx2));
            if (idx1 > idx2) {
                j++;
            }
            else {
                i++;
            }
        }
        while (i < n) {
            min = Math.min(min, Math.abs(l1.get(i++) - l2.get(m - 1)));
        }
        while (j < m) {
            min = Math.min(min, Math.abs(l1.get(n - 1) - l2.get(j++)));
            j++;
        }
        return min;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "efd", "abcd", "perfect", "makes"};
        WordDistanceII word = new WordDistanceII(words);
        System.out.println(word.getDistance("makes", "makes"));
    }

}
