package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/4/3.
 */
public class WeightedSum {

    public int weightedSum(List list) {
        return weightedSumHelper(list, 1);
    }

    public int weightedSumHelper(List<Object> list, int depth) {
        int ans = 0;
        for (Object l : list) {
            if (l instanceof List) {
                ans += weightedSumHelper((List)l, depth + 1);
            }
            else {
                int num = (Integer)l;
                ans += depth * num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        List<Object> l1 = new ArrayList<>();
        l1.add(1); l1.add(1);
        List<Object> l2 = new ArrayList<>();
        l2.add(1); l2.add(1);
        list.add(l1); list.add(2); list.add(l2);
        WeightedSum w = new WeightedSum();
        System.out.println(w.weightedSum(list));
    }
}
