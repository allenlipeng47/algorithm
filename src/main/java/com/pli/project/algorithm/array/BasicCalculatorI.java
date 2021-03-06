package com.pli.project.algorithm.array;

import java.util.Stack;

/**
 * Created by lipeng on 2016/3/8.
 "3+2*2" = 7
 " 3/2 " = 1
 " 3+5 / 2 " = 5
 */
public class BasicCalculatorI {

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0, len = s.length();
        char sign = '+';
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == ' ' && i != len - 1) {
                continue;
            }
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            // it means this one is a sign or it is the end. Use previous one to calculate
            if (ch < '0' || ch > '9' || i == len - 1) {
                switch (sign) {
                    case '+':
                        stack.add(num);
                        break;
                    case '-':
                        stack.add(-num);
                        break;
                    case '*':
                        stack.add(stack.pop() * num);
                        break;
                    case '/':
                        stack.add(stack.pop() / num);
                        break;
                    default:
                        continue;
                }
                num = 0;
                sign = ch;
            }
        }
        int ans = 0;
        while (!stack.empty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
//        String str = "3+2*2";
//        String str = " 3/2 ";
//        String str = " 3+5 / 2 ";
//        String str = "(1)";
//        String str = "2147483647";
        String str = "1";
        System.out.println(calculate(str));
    }
}
