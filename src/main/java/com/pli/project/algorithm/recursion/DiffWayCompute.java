package com.pli.project.algorithm.recursion;

import com.pli.project.algorithm.exercise2014.IntegerSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by lipeng on 2016/1/28.
 */
public class DiffWayCompute {

    public static List<Integer> diffWaysToCompute(String input) {
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            return new ArrayList<Integer>(Arrays.asList(Integer.valueOf(input)));
        }
        int n = input.length();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            List<Integer> left, right;
            if (!(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'))
                continue;
            left = diffWaysToCompute(input.substring(0, i));
            right = diffWaysToCompute(input.substring(i + 1, input.length()));
            switch (input.charAt(i)) {
                case '+':
                    for (Integer ele1 : left)
                        for (Integer ele2 : right)
                            ans.add(ele1 + ele2);
                    break;
                case '-':
                    for (Integer ele1 : left)
                        for (Integer ele2 : right)
                            ans.add(ele1 - ele2);
                    break;
                case '*':
                    for (Integer ele1 : left)
                        for (Integer ele2 : right)
                            ans.add(ele1 * ele2);
                    break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        String input = "2-1-1";
        String input = "0+1";
        System.out.println(diffWaysToCompute(input));
    }
}
