package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/7/24.
 * https://leetcode.com/problems/valid-palindrome/
 */
public class l125ValidPalindrome {

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char lc = s.charAt(left), rc = s.charAt(right);
            if (!(lc >= 'a' && lc <= 'z' || lc >= '0' && lc <= '9')) {
                left++;
                continue;
            }
            else if (!(rc >= 'a' && rc <= 'z' || rc >= '0' && rc <= '9')) {
                right--;
                continue;
            }
            if (lc != rc) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }

}
