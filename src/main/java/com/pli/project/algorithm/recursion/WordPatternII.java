package com.pli.project.algorithm.recursion;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by lipeng on 2016/1/17.
 * Leetcode WordPatternII
 * Given a pattern and a string str, find if str follows the same pattern.
 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
 Examples:
 pattern = "abab", str = "redblueredblue" should return true.
 pattern = "aaaa", str = "asdasdasdasd" should return true.
 pattern = "aabb", str = "xyzabcxzyabc" should return false.
 * http://www.cnblogs.com/jcliBlogger/p/4870514.html
 */
public class WordPatternII {

    public static boolean wordPatternMatch(String pattern, String str) {
        HashMap<Character, String> hm = new HashMap<Character, String>();
        HashSet<String> usedStr = new HashSet<String>();
        return patternHelper(pattern, 0, str, 0, hm, usedStr);
    }

    public static boolean patternHelper(String pattern, int i, String str, int j, HashMap<Character, String> hm, HashSet<String> usedStr) {
        if (i >= pattern.length() && j >= str.length())
            return true;
        if (i >= pattern.length() || j >= str.length())
            return false;
        char ch = pattern.charAt(i);
        String hmWord = hm.get(ch);
        if (hmWord == null) {    // if pattern doesn't exist, try to put new pattern for this char.
            for(int delta = 1; j + delta <= str.length(); delta++) {
                String potentialWord = str.substring(j, j + delta);
                if(usedStr.contains(potentialWord))
                    continue;
                hm.put(ch, potentialWord);
                usedStr.add(potentialWord);
                if(patternHelper(pattern, i + 1, str, j + delta, hm, usedStr))
                    return true;
                hm.remove(ch);  // backtrace
                usedStr.remove(potentialWord);
            }
        }
        // if hmWord is not null and hmWord match in str. Try next position
        else if (str.startsWith(hmWord, j) && patternHelper(pattern, i + 1, str, j + hmWord.length(), hm, usedStr))
            return true;
        return false;
    }

    public static void main(String[] args) {
        String pattern = "abab";
        String str = "xyzabcxzyabc";
        System.out.println(wordPatternMatch(pattern, str));
    }

}
