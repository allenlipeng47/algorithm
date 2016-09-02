package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/9/1.
 * https://leetcode.com/problems/isomorphic-strings/
 * The idea is to record the position of the element.
 * When the position of 2 elements are not equal, then return false.
 * Each loop, update the current position.
 */
public class l205IsomorphicString {

    public boolean isIsomorphic(String s, String t) {
        int[] pos = new int[512];
        for (int i = 0; i < s.length(); i++) {
            if (pos[s.charAt(i)] != pos[t.charAt(i) + 256]) {
                return false;
            }
            pos[s.charAt(i)] = pos[t.charAt(i)] = i + 1;
        }
        return true;
    }

}
