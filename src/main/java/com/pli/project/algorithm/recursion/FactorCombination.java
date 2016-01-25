package com.pli.project.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/1/24.
 * http://www.cnblogs.com/airwindow/p/4822572.html
 * Problem:

 Numbers can be regarded as product of its factors. For example,

 8 = 2 x 2 x 2;
 = 2 x 4.
 Write a function that takes an integer n and return all possible combinations of its factors.

 Note:

 Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
 You may assume that n is always positive.
 Factors should be greater than 1 and less than n.


 Examples:
 input: 1
 output:
 []

 input: 37
 output:
 []

 input: 12
 output:
 [
 [2, 6],
 [2, 2, 3],
 [3, 4]
 ]

 input: 32
 output:
 [
 [2, 16],
 [2, 2, 8],
 [2, 2, 2, 4],
 [2, 2, 2, 2, 2],
 [2, 4, 4],
 [4, 8]
 ]
 */
public class FactorCombination {

    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        getFactorsHelper(ans, new ArrayList<Integer>(), n, 2);
        return ans;
    }

    public static void getFactorsHelper(List<List<Integer>> ans, List<Integer> list, int n, int last) {
        if (n == 1) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = last; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                getFactorsHelper(ans, list, n / i, i);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getFactors(24));
    }

}
