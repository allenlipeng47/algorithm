package com.pli.project.algorithm.array;

import org.omg.CORBA.TRANSACTION_MODE;

import java.util.Stack;

/**
 * Created by lipeng on 2016/3/8.
 "3+2*2" = 7
 " 3/2 " = 1
 " 3+5 / 2 " = 5
 */
public class BasicCalculator_OPG {

    private static final int LESS = 0;
    private static final int GREATER = 1;
    private static final int EQUAL = 2;
    private static final int ERROR = 3;

    private static int opMatrix[][] = {
            {LESS, LESS, LESS, LESS, GREATER, LESS, GREATER},
            {LESS, LESS, LESS, LESS, GREATER, LESS, GREATER},
            {GREATER, GREATER, LESS, LESS, GREATER, LESS, GREATER},
            {GREATER, GREATER, LESS, LESS, GREATER, LESS, GREATER},
            {GREATER, GREATER, GREATER, GREATER, ERROR, GREATER, GREATER},
            {LESS, LESS, LESS, LESS, EQUAL, LESS, ERROR},
            {LESS, LESS, LESS, LESS, LESS, LESS, EQUAL}
    };

    private static int getOp(char ch) {
        switch (ch) {
            case '+':
                return 0;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 3;
            case '(':
                return 4;
            case ')':
                return 5;
            case '#':
                return 6;
            default:
                return 7;
        }
    }

    private static long op(long num1, char ch, long num2) {
        switch (ch) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }
        return 0;
    }

    public static int calculate(String s) {
        s = s.replace(" ", "") + "#";
        Stack<Character> opStack = new Stack<>();
        Stack<Long> numStack = new Stack<>();
        opStack.add('#');
        int i = 0;
        while (!opStack.isEmpty()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int j;
                for (j = i + 1; j < s.length() && Character.isDigit(s.charAt(j)); j++);
                long num = Long.valueOf(s.substring(i, j));
                numStack.add(num);
                i = j;
                continue;
            }
            char topOp = opStack.peek();
            while (opMatrix[getOp(ch)][getOp(topOp)] == LESS) {
                long num2 = numStack.pop();
                long num1 = numStack.pop();
                numStack.add(op(num1, opStack.pop(), num2));
                topOp = opStack.peek();
            }
            switch (opMatrix[getOp(ch)][getOp(topOp)]) {
                case GREATER:
                    opStack.add(ch);
                    break;
                case EQUAL:
                    opStack.pop();
                    break;
                default:
            }
            i++;
        }
        return numStack.pop().intValue();
    }

    public static void main(String[] args) {
//        String str = "3+2*2";
//        String str = " 3/2 ";
//        String str = " 3+5 / 2 ";
//        String str = "(1)";
        String str = "2147483647";
        System.out.println(calculate(str));
    }
}
