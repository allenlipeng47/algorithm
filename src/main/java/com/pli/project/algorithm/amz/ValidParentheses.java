package com.pli.project.algorithm.amz;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by lipeng on 2016/8/10.
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> l = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                l.add(ch);
                continue;
            }
            if (!l.isEmpty() && (ch == ')' && l.peek() == '('
                    || ch == ']' && !l.isEmpty() && l.peek() == '['
                    || ch == '}' && !l.isEmpty() && l.peek() == '{')) {
                l.pop();
            }
            else {
                return false;
            }
        }
        return l.isEmpty();
    }

}
