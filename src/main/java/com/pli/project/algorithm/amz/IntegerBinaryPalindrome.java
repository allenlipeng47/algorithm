package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/23.
 * Check if the binary of the number is palindrome
 */
public class IntegerBinaryPalindrome {

    public boolean isPalindrome(int n) {
        int a = n, b = 0;
        while (b < n) {
            b = (b << 1) | (a & 1);
            a = a >> 1;
        }
        return b == n;
    }

}
