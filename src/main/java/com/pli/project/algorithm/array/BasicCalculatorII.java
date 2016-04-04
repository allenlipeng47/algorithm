package com.pli.project.algorithm.array;

import java.util.Stack;

/**
 * Created by lipeng on 2016/3/8.
 "1 + 1" = 2
 " 2-1 + 2 " = 3
 "(1+(4+5+2)-3)+(6+8)" = 23
 */
public class BasicCalculatorII {



    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0, sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }
            else if (Character.isDigit(ch)) {
                int num = 0;
                for (; i < s.length() && Character.isDigit(s.charAt(i)); i++) {
                    num = num * 10 + (s.charAt(i) - '0');
                }
                result += num * sign;
                i--;
            }
            else if (ch == '+') {
                sign = 1;
            }
            else if (ch == '-') {
                sign = -1;
            }
            else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            else if (ch == ')') {
                result = stack.pop() * result + stack.pop();
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String str =  "2147483647";
        System.out.println(calculate(str));
    }
}
