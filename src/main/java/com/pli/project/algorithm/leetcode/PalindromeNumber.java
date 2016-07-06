package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/7/5.
 * https://leetcode.com/problems/palindrome-number/
 * The solution is to move the lower part to another number sum, and shrink x. After moved half, compare sum and x.
 */
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) {
            return false;
        }
        int sum = 0;
        while (sum < x) {
            sum = sum * 10 + x % 10;
            x /= 10;
        }
        return x == sum || x == sum / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }

}
