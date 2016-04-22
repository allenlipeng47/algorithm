package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/4/20.
 * http://www.danielbit.com/blog/puzzle/leetcode/leetcode-missing-ranges#comments
 * Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
 * For example, given [0, 1, 3, 50, 75], return [¡°2¡±, ¡°4->49¡±, ¡°51->74¡±, ¡°76->99¡±]
 */
public class MissingRanges {


    public static List<String> findMissingRanges(int[] vals) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= vals.length; i++) {
            int curr = (i == vals.length) ? 100 : vals[i];
            if (curr > vals[i - 1] + 2) {
                ans.add((vals[i - 1] + 1) + "->" + (curr - 1));
            }
            else if (curr == vals[i - 1] + 2) {
                ans.add(String.valueOf(vals[i - 1] + 1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] vals = {0, 1, 3, 50, 75, 98};
        List<String> ans = findMissingRanges(vals);
        System.out.println(ans);
    }

}
