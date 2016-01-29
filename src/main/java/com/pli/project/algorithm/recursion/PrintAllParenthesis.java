package com.pli.project.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/1/22.
 */
public class PrintAllParenthesis {

    public static ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> list = new ArrayList<String>();
        parenthesisHelper(0, 0, n, list, "");
        return list;
    }

    public static void parenthesisHelper(int open, int close, int pair, ArrayList<String> list, String ans) {
        if (close == pair) {
            list.add(ans);
            return;
        }
        if (open < pair) {
            parenthesisHelper(open + 1, close, pair, list, ans + "(");
        }
        if (close < open) {
            parenthesisHelper(open, close + 1, pair, list, ans + ")");
        }
    }

    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        System.out.println(list);
    }
}
