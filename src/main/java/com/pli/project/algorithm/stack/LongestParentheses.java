package com.pli.project.algorithm.stack;

import java.util.Stack;

/**
 * Created by lipeng on 2015/10/15.
 */
public class LongestParentheses {

    public static int getLongestParentheses(char[] chs) {
        if(chs==null||chs.length==0) {
            return 0;
        }
        int maxSize = 0;
        int start = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<chs.length; i++) {
            if(chs[i]=='(') {
                stack.push(i);
            }
            else if(stack.empty()) {
                start = i + 1;
            }
            else {
                stack.pop();
                maxSize = stack.isEmpty() ? Math.max(maxSize, i-start+1) : Math.max(maxSize, i-stack.peek());
            }
        }
        return maxSize;
    }

    public static int getMaxParentheses2(char[] chs) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = Integer.MIN_VALUE;
        for(int i=0; i<chs.length; i++) {
            if(stack.isEmpty() || chs[i]=='(' || chs[stack.peek()]==')') {
                stack.push(i);
            }
            else {
                stack.pop();
                int currMax = stack.isEmpty() ? i+1 : i-stack.peek();
                max = currMax > max ? currMax : max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        char[] chs = {'(', ')', '(', '(', '(', ')', '(', '(', ')', ')'};
//        char[] chs = {'(', ')', ')', ')', '(', '(', ')', ')'};
//        char[] chs = {')', '(', '(', ')', ')','(','(', ')', ')'};
//        char[] chs = {'(', ')', '(', ')'};
//        char[] chs = {')'};
//        char[] chs = {'(', '(', ')', ')', '(', '(', '(', '(', '(', '(', ')', ')', ')', ')'};
        System.out.println(getLongestParentheses(chs));
    }

}
