package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/8/5.
 * https://leetcode.com/problems/scramble-string/
 */
public class l87ScrambleString {

    public static boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) { // this check to avoid enter useless loop.
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int count : letters) {
            if (count != 0) {
                return false;
            }
        }
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(s1.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s1.length() - i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isScramble("abc", "bca"));
    }
}
