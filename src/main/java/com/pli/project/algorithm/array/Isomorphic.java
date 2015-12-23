package com.pli.project.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lipeng on 2015/12/22.
 Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic if the characters in s can be replaced to get t.
 For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
 http://www.programcreek.com/2014/05/leetcode-isomorphic-strings-java/
 */
public class Isomorphic {

    public static boolean isIsomorphic(String str1, String str2) {
        if(str1==null || str2==null || str1.length()!=str2.length())
            return false;
        Map<Character, Character> map = new HashMap<Character, Character>();
        for(int i=0; i<str1.length(); i++) {
            char c1 = str1.charAt(i), c2 = str2.charAt(i);
            if(map.get(c1)==null && map.get(c2)==null) {
                map.put(c1, c2);
                map.put(c2, c1);
            }
            else if(map.get(c1)==null || map.get(c2)==null || !(map.get(c1).charValue()==c2 && map.get(c2).charValue()==c1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "ed";
        String str2 = "cc";
        System.out.println(isIsomorphic(str1, str2));
    }
}
