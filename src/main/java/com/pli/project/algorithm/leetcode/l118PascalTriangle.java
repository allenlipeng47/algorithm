package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/7/25.
 * https://leetcode.com/problems/pascals-triangle/
 * Using the formula C(i, j) = C(i - 1, j - 1) + C(i - 1, j) except for first and last element
 */
public class l118PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) {
            return ans;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curr.add(1);
                }
                else {
                    curr.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(curr);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

}
