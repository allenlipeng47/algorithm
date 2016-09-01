package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/8/31.
 * https://leetcode.com/problems/lexicographical-numbers/
 */
public class l389LexicographicalNumber {

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, ans);
        }
        return ans;
    }

    private static void dfs(int curr, int n, List<Integer> ans) {
        if (curr > n) {
            return;
        }
        ans.add(curr);
        for (int i = 0; i <= 9; i++) {
            dfs(curr * 10 + i, n, ans);
        }
    }

    public static void main(String[] args) {
        System.out.println(lexicalOrder(40));
    }

}
