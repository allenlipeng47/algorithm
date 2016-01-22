package com.pli.project.algorithm.recursion;

import java.util.*;

/**
 * Created by lipeng on 2016/1/19.
 * http://www.cnblogs.com/jcliBlogger/p/4752065.html
 */
public class AllPalindrome {

    public static List<String> generatePalindromes(String str) {
        char[] chs = str.toCharArray();
        // count the number of each char. Put them into hashmap
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (char ch : chs) {
            Integer value = hm.get(ch);
            if (value == null)
                hm.put(ch, 1);
            else
                hm.put(ch, value + 1);
        }
        int odd = 0;
        Character oddCh = '\0';
        // find the odd char. If odd char are greater than 1, return empty list
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
           if ((entry.getValue() & 1) == 1) {
               if (++odd > 1)
                   return new ArrayList<String>();
               oddCh = entry.getKey();
               entry.setValue(entry.getValue() - 1);
           }
        }
        // permuStr has the half size of whole string. Same char stay together
        StringBuffer permuStr = new StringBuffer();
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            int n = entry.getValue() >> 1;
            for (int i = 0; i < n; i++)
                permuStr.append(entry.getKey());
        }
        // permutate permuStr
        List<String> permutateRes = new ArrayList<String>();
        permutate(permuStr.toString().toCharArray(), new boolean[permuStr.length()], permutateRes, new StringBuffer());
        // return final result from permutation
        List<String> res = new ArrayList<String>();
        for (String tmp : permutateRes)
            res.add(tmp.toString() + oddCh + new StringBuffer(tmp).reverse().toString());
        return res;
    }

    public static void permutate(char[] chs, boolean[] used, List<String> res, StringBuffer currRes) {
        if (currRes.length() == chs.length) {
            res.add(currRes.toString());
            return;
        }
        for (int i = 0; i < chs.length; i++) {
            if (used[i] || (i > 0 && chs[i] == chs[i - 1] && !used[i - 1]))
                continue;
            currRes.append(chs[i]);
            used[i] = true;
            permutate(chs, used, res, currRes);
            used[i] = false;
            currRes.deleteCharAt(currRes.length() - 1);
        }
    }

    public static void main(String[] args) {
        String str = "aaaabbccd";
        List<String> list = generatePalindromes(str);
        System.out.println(list);
    }

}
