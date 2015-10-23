package com.pli.project.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2015/10/21.
 * Given a string, we try to split the string to each sub-string. Each sub-string needs to be palindrome.
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 */
public class AllPalindromePartition {


    public static void main(String[] args) {
        String str = "abacbdbc";
        System.out.println(getAllPalindromePartition(str));
    }

    public static List<List<String>> getAllPalindromePartition(String str) {
        List<List<String>> result = new ArrayList<List<String>>();
        getAllPalindromePartitionUtil(str, 0, result, new ArrayList<String>());
        return result;
    }

    public static void getAllPalindromePartitionUtil(String str, int start, List<List<String>> result, List<String> currResult) {
        if(start==str.length()) {
            ArrayList<String> curr = new ArrayList<String>(currResult);
            result.add(curr);
        }
        else {
            for(int i=start; i<str.length(); i++) {
                String currStr = str.substring(start, i+1);
                if(isPalindrome(currStr)) {
                    currResult.add(currStr);
                    getAllPalindromePartitionUtil(str, i + 1, result, currResult);
                    currResult.remove(currResult.size()-1);
                }
            }
        }
    }

    public static boolean isPalindrome(String str) {
        int left=0, right=str.length()-1;
        while(left<right) {
            if(str.charAt(left)==str.charAt(right)) {
                left++;
                right--;
            }
            else {
                return false;
            }
        }
        return true;
    }


}