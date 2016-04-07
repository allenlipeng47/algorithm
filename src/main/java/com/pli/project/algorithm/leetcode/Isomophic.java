package com.pli.project.algorithm.leetcode;

import java.util.HashMap;

/**
 * Created by lipeng on 2016/4/4.
 */
public class Isomophic {

    public boolean isIsomorphic(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int len = str1.length();
        HashMap<Character, Character> hm1 = new HashMap<>(), hm2 = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char ch1 = str1.charAt(i), ch2 = str2.charAt(i);
            if (hm1.get(ch1) != null && hm1.get(ch1) == ch2) {
                continue;
            }
            else if (!hm1.containsKey(ch1) && !hm2.containsKey(ch2)) {
                hm1.put(ch1, ch2);
                hm2.put(ch2, ch1);
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Isomophic isomophic = new Isomophic();
        System.out.println(isomophic.isIsomorphic("egg", "add"));
        System.out.println(isomophic.isIsomorphic("foo", "bar"));
        System.out.println(isomophic.isIsomorphic("paper", "title"));
//        HashMap<Character, Character> hm = new HashMap<>();
//        System.out.println(hm.get('a'));
    }

}
