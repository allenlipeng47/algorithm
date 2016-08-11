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
        Map<Character, String> hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
        for (int i = 0; i < digits.length(); i++) {
            ans = addLetters(ans, hm.get(digits.charAt(i)));
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
