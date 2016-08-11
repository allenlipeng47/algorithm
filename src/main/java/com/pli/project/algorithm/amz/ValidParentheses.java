package com.pli.project.algorithm.amz;

import java.util.LinkedList;

/**
 * Created by lipeng on 2016/8/10.
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        LinkedList<Character> l = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                l.add(ch);
                continue;
            }
            if (!l.isEmpty() && (ch == ')' && l.getLast() == '('
                    || ch == ']' && !l.isEmpty() && l.getLast() == '['
                    || ch == '}' && !l.isEmpty() && l.getLast() == '{')) {
                l.removeLast();
            }
            else {
                return false;
            }
        }
        return l.isEmpty();
    }

}
