package com.pli.project.algorithm.leetcode;

import java.util.List;
import java.util.Stack;
import com.pli.project.algorithm.util.NestedInteger;

/**
 * Created by lipeng on 2016/8/31.
 * If it is '-', then sign = -1
 * If it is digit, then calculate digit
 * If it is '[', then push to stack.
 * If it is ']', pop stack
 * If it is ',', continue
 *
 * There maybe digit before ',' or ']'. So when there is ',' or ']', check if add digit
 */
public class l385MiniParser {

    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> stack = new Stack();
        stack.add(new NestedInteger()); // top level is a dummy NestedInteger
        int sign = 1, digit = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '-') {
                sign = -1;
            }
            else if (Character.isDigit(ch)) {
                digit = digit * 10 + ch - '0';
            }
            else if (ch == '[') {   // peek element will include this new NestdInteger
                NestedInteger curr = new NestedInteger();
                stack.peek().add(curr);
                stack.add(curr);
            }
            else if (ch == ',' && Character.isDigit(s.charAt(i - 1))) {
                stack.peek().add(new NestedInteger(digit * sign));
                digit = 0;
                sign = 1;
            }
            else if (ch == ']') {
                if (Character.isDigit(s.charAt(i - 1))) {
                    stack.peek().add(new NestedInteger(digit * sign));
                    digit = 0;
                    sign = 1;
                }
                stack.pop();
            }
        }
        if (s.length() > 0 && Character.isDigit(s.charAt(s.length() - 1))) {    // handle "321". Only digit
            stack.peek().add(new NestedInteger(digit * sign));
        }
        return stack.pop().getList().get(0);
    }


}
