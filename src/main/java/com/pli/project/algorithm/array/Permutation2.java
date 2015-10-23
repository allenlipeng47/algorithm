package com.pli.project.algorithm.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by lipeng on 2015/10/19.
 * https://leetcode.com/problems/palindrome-partitioning/
 * This is a very traditional permutation method. The idea is from http://www.programcreek.com/2013/03/leetcode-palindrome-partitioning-java/
 */
public class Permutation2 {

    public static List<List<String>> getPermutation(String str) {
        List<List<String>> result = new ArrayList<List<String>>();
        getPermutationUtil(str, 0, result, new ArrayList<String>());
        return result;
    }

    public static void getPermutationUtil(String str, int start, List<List<String>> result, List<String> currResult) {
        if(start==str.length()) {
            ArrayList<String> curr = new ArrayList<String>(currResult);
            result.add(curr);
        }
        else {
            for(int i=start; i<str.length(); i++) {
                String currStr = str.substring(start, i+1);
                currResult.add(currStr);
                getPermutationUtil(str, i + 1, result, currResult);
                currResult.remove(currResult.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        List<List<String>> list = getPermutation(str);
        System.out.println(list);
    }

}



