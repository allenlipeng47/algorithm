package com.pli.project.algorithm.leetcode;

import java.util.*;

/**
 * Created by lipeng on 2016/7/23.
 */
public class PalindromePartition {



    // 1. Use memory. Same technique as Word Break II
    // 2. Use efficient palindrome compare. Same as PalindromePartitionII
    public static List<List<String>> partition2(String s) {
        HashMap<String, List<List<String>>> hm = new HashMap<>();
        List<List<String>> init = new ArrayList<>();
        init.add(new LinkedList<>());
        hm.put("", init);
        return helper2(s, hm, new boolean[s.length()][s.length()], 0);
    }

    public static List<List<String>> helper2(String s, HashMap<String, List<List<String>>> hm, boolean[][] dp, int pos) {
        if (hm.containsKey(s.substring(pos, s.length()))) {
            return hm.get(s.substring(pos, s.length()));
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = pos; i < s.length(); i++) {
            dp[pos][i] = s.charAt(pos) == s.charAt(i) && (pos + 1 >= i || dp[pos + 1][i - 1]);
            if (dp[pos][i]) {
                List<List<String>> list = helper2(s, hm, dp, i + 1);
                String str = s.substring(pos, i + 1);
                for (List<String> subList : list) {
                    LinkedList<String> curr = new LinkedList<>(subList);
                    curr.addFirst(str);
                    ans.add(curr);
                }
            }
            hm.put(s.substring(pos), ans);
        }
        return ans;
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(s, 0, ans, new ArrayList<>());
        return ans;
    }

    public static void helper(String s, int pos, List<List<String>> ans, List<String> curr) {
        if (pos >= s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            if (isPalindrome(s, pos, i)) {
                curr.add(s.substring(pos, i + 1));
                helper(s, i + 1, ans, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }


}
