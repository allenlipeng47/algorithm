package com.pli.project.algorithm.leetcode;

import java.util.Stack;

/**
 * Created by lipeng on 2016/7/11.
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * Solution by using stack.
 */
public class ReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int tmp = stack.pop();
                    stack.push(stack.pop() / tmp);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
//        String[] tokens = {"2", "1", "+", "3", "*"};
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));
    }

}
