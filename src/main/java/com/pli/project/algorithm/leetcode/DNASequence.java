package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by lipeng on 2016/4/13.
 */
public class DNASequence {

    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> ans = new HashSet<>();
        if (s.length() <= 10) {
            return new ArrayList();
        }
        int num = 0, len = s.length();
        for (int i = 0; i < 10; i++) {
            num = (num << 3) | (s.charAt(i) & 7);
        }
        HashSet<Integer> hs = new HashSet<>();
        hs.add(num);
        for (int i = 10; i < len; i++) {
            num = ((num << 3) | (s.charAt(i) & 7)) & 0x3fffffff;
            if (hs.contains(num)) {
                ans.add(s.substring(i - 9, i + 1));
            }
            hs.add(num);
        }
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        DNASequence dnaSequence = new DNASequence();
        System.out.println(dnaSequence.findRepeatedDnaSequences(str));
    }

}
