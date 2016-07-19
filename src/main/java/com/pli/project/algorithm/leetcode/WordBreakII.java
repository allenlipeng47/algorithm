package com.pli.project.algorithm.leetcode;

import java.util.*;

/**
 * Created by lipeng on 2016/7/15.
 */
public class WordBreakII {

    public static List<String> wordBreak2(String s, Set<String> wordDict) {
        List<String> ans = new ArrayList<>();
        helper2(s, wordDict, "", ans, 0);
        return ans;
    }

    // this is the tradition, classical permutation. But it won't memorize the part result.
    public static void helper2(String s, Set<String> wordDict, String curr, List<String> ans, int pos) {
        if (pos == s.length()) {
            ans.add(curr.substring(1, curr.length()));
            return;
        }
        for (String word : wordDict) {
            if (pos + word.length() <= s.length() && s.substring(pos, pos + word.length()).equals(word)) {
                helper2(s, wordDict, curr + " " + word, ans, pos + word.length());
            }
        }
    }



    public static void main(String[] args) {
        String[] dict = {"cat", "cats", "and", "sand", "dog"};
        Set<String> set = new HashSet<>();
        for (String s : dict) {
            set.add(s);
        }
        String s = "catsanddog";
        System.out.println(wordBreak(s, set));
    }

    public static List<String> wordBreak(String s, Set<String> wordDict) {
        return helper(s, wordDict, new HashMap<>());
    }

    // the helper returns a result list. Put this list into hashmap. This can help to memorize the result.
    public static List<String> helper(String s, Set<String> wordDict, Map<String, List<String>> mem) {
        if (mem.containsKey(s)) {
            return mem.get(s);
        }
        List<String> ans = new ArrayList<>();
        if (s.length() == 0) {
            ans.add("");
            return ans;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> currList = helper(s.substring(word.length()), wordDict, mem);
                for (String subList : currList) {
                    ans.add(word + (subList.isEmpty() ? "" : " ") + subList);
                }
            }
        }
        mem.put(s, ans);
        return ans;
    }
}




