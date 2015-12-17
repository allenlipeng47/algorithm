package com.pli.project.algorithm.stack;

import com.sun.javafx.geom.AreaOp;

import java.util.Stack;

/**
 * Created by lipeng on 2015/12/16.
 */
public class OPG {

    public static final int LESS = 1;
    public static final int GREATER = 2;
    public static final int EQUAL = 3;
    public static final int WRONG = 4;

    public static final int PLUS = 0;
    public static final int MINUS = 1;
    public static final int TIMES = 2;
    public static final int DIVIDE = 3;
    public static final int LEFT_PARENTHESIS = 4;
    public static final int RIGHT_PARENTHESIS = 5;
    public static final int POUND = 6;

    /*
        0   1   2   3   4   5   6
        +   -   *   /   (   )   #
    +   <   <   <   <   >   <   na
    -   <   <   <   <   >   <   na
    *   >   >   <   <   >   <   na
    /   >   >   <   <   >   <   na
    (   >   >   >   >   >   na  na
    )   <   <   <   <   =   <   na
    #   <   <   <   <   na  <   na
     */
    public static final int[][] opMatrix= {
            {LESS, LESS, LESS, LESS, GREATER, LESS, WRONG},
            {LESS, LESS, LESS, LESS, GREATER, LESS, WRONG},
            {GREATER, GREATER, LESS, LESS, GREATER, LESS, WRONG},
            {GREATER, GREATER, LESS, LESS, GREATER, LESS, WRONG},
            {GREATER, GREATER, GREATER, GREATER, GREATER, WRONG, WRONG},
            {LESS, LESS, LESS, LESS, EQUAL, LESS, WRONG},
            {LESS, LESS, LESS, LESS, WRONG, LESS, WRONG},
    };

    public static int getOperator(char ch) {
        switch (ch) {
            case '+':
                return PLUS;
            case '-':
                return MINUS;
            case '*':
                return TIMES;
            case '/':
                return DIVIDE;
            case '(':
                return LEFT_PARENTHESIS;
            case ')':
                return RIGHT_PARENTHESIS;
            case '#':
                return POUND;
            default:
                return -1;
        }
    }

    public static int op(int operator, int a, int b) {
        switch (operator) {
            case PLUS:
                return a+b;
            case MINUS:
                return a-b;
            case TIMES:
                return a*b;
            case DIVIDE:
                return a/b;
            default:
                return 0;
        }
    }

    public static int calculate(String str) {
        if(str==null || str.length()<1)
            return Integer.MIN_VALUE;
        str = str + '#';
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<Integer> opStack = new Stack<Integer>();
        int nextOp = -1;
        int nextNum = -1;
        int pos = 0;
        while (!(opStack.isEmpty() && nextOp==POUND) && pos<str.length()) {
            if(str.charAt(pos)>='0' && str.charAt(pos)<='9') {
                nextNum = getNum(str, pos);
                numStack.push(nextNum);
                int numLength = String.valueOf(nextNum).length();
                if((pos>=1 && str.charAt(pos-1)==')') || (str.charAt(pos+numLength)=='('))
                    return Integer.MIN_VALUE;   // avoid (3+1)3, and 3(1+2) exception
                pos += String.valueOf(nextNum).length();

            }
            else if(opStack.isEmpty()) {
                opStack.push(getOperator(str.charAt(pos++)));
            }
            else {
                int topOp = opStack.peek();
                nextOp = getOperator(str.charAt(pos));
                switch (opMatrix[nextOp][topOp]) {
                    case LESS:
                        if(numStack.size()<2)
                            return Integer.MIN_VALUE;
                        int b = numStack.pop();
                        int a = numStack.pop();
                        int value = op(topOp, a, b);
                        numStack.push(value);
                        opStack.pop();
                        break;
                    case GREATER:
                        opStack.push(nextOp);
                        pos++;
                        break;
                    case EQUAL:
                        opStack.pop();
                        pos++;
                        break;
                    default:
                        return Integer.MIN_VALUE;   //default is wrong
                } // switch
            }
        }
        return numStack.pop();
    }

    public static int getNum(String str, int start) {
        int end;
        for(end=start; end<str.length() && str.charAt(end)>='0' && str.charAt(end)<='9'; end++);
        return Integer.valueOf(str.substring(start, end));
    }

    public static void main(String[] args) {
        String str = "(100+23)+5+3-2*3";
        System.out.println(calculate(str));
    }

}
