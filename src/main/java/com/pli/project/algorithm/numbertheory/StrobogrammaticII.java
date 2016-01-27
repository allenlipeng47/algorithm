package com.pli.project.algorithm.numbertheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lipeng on 2016/1/26.
 * Find all strobogrammatic number with length n
 */
public class StrobogrammaticII {

    public static final char[][] chs = {{'6', '9'}, {'9', '6'}, {'1', '1'}, {'8', '8'}, {'0', '0'}};

    public static List<String> findStrobogrammatic(int n) {
        return findHelper(n, n);
    }

    public static ArrayList<String> findHelper(int num, int n) {
        if (num == 1) {
            return new ArrayList<String>(Arrays.asList("0", "1", "8"));  // handle the middle one
        }
        else if (num <= 0) {
            return new ArrayList<String>(Arrays.asList(""));  // handle the middle one
        }
        List<String> list = findHelper(num - 2, n);
        int to = (num == n ? 3 : 4);    // if is last outside, 0 shouldn't be considered
        ArrayList<String> newList = new ArrayList<String>();
        for (String str : list) {
            for (int i = 0; i <= to; i++)
                newList.add(chs[i][0] + str + chs[i][1]);
        }
        list = null;
        return newList;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        System.out.println(findStrobogrammatic(4));
    }
}
