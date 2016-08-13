package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lipeng on 2016/8/12.
 * https://leetcode.com/problems/anagrams/
 * The key idea is to store the sorted str as key.
 */
public class l49GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String keyStr = String.valueOf(chs);
            List<String> currList = hm.getOrDefault(keyStr, new ArrayList<>());
            currList.add(str);
            hm.put(keyStr, currList);
        }
        return new ArrayList(hm.values());
    }

}
