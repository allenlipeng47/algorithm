package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/9/1.
 * https://leetcode.com/problems/generate-parentheses/
 */
public class l22GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n, 0, 0, ans, new StringBuilder());
        return ans;
    }

    private void helper(int n, int open, int close, List<String> ans, StringBuilder sb) {
        if (close == n) {
            ans.add(sb.toString());
        }
        if (open < n) {
            sb.append("(");
            helper(n, open + 1, close, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            helper(n, open, close + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
