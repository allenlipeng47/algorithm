package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/23.
 * https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {

    // 1. negative number doesn't has palindrome
    // 2. number with last digit 0 is not palindrome. Such as 1310
    public boolean isPalindrome(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) {
            return false;
        }
        long a = 0, b = x;
        while (a < x) {
            a = a * 10 + b % 10;
            b /= 10;
        }
        return a == x;
    }

}
