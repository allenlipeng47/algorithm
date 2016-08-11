package com.pli.project.algorithm.amz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lipeng on 2016/8/10.
 */
public class LetterCombinationOfPhoneNumber {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        ans.add("");
        String[] mapping = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Map<Character, String> hm = new HashMap<>();
        for (int i = 0; i < digits.length(); i++) {
            ans = addLetters(ans, mapping[digits.charAt(i) - '2']);
        }
        return ans;
    }

    private List<String> addLetters(List<String> list, String str) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (String currStr : list) {
                ans.add(currStr + str.charAt(i));
            }
        }
        return ans;
    }
}
