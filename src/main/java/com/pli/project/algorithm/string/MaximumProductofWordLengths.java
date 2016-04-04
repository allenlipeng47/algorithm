package com.pli.project.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lipeng on 2016/1/3.
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 * Given a string array words, find the maximum val of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

 Example 1:
 Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 Return 16
 The two words can be "abcw", "xtfn".

 Example 2:
 Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 Return 4
 The two words can be "ab", "cd".

 Example 3:
 Given ["a", "aa", "aaa", "aaaa"]
 Return 0
 No such pair of words.

 The idea is to transfer string to integer. String consists word of 26, and integer is 4 bytes, which has 32 bits.
 */
public class MaximumProductofWordLengths {

    // transfrom string to integer
    public static int fromStringToInt(String str) {
        int n = str.length();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int bits = str.charAt(i) - 'a';
            ans = ans | (1 << bits);
        }
        return ans;
    }

    public static int maxProduct(String[] words) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(String word : words)
            hm.put(word, fromStringToInt(word));
        int ans = 0;
        for(Map.Entry<String, Integer> entry1 : hm.entrySet()) {
            for(Map.Entry<String, Integer> entry2 : hm.entrySet()) {
                if((entry1.getValue() & entry2.getValue()) == 0 && entry1.getKey().length() * entry2.getKey().length() > ans)
                    ans = entry1.getKey().length() * entry2.getKey().length();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        int ans = maxProduct(words);
        System.out.println(ans);
    }

}
