package com.pli.project.algorithm.array;

/**
 * Created by lipeng on 2016/1/6.
 * https://leetcode.com/problems/additive-number/
 */
public class AdditiveNumber {

    public static boolean isAdditiveNumber(String str) {
        int n = str.length(), mid = n >> 1;
        for(int len1 = 1; len1 < mid + 1; len1++)   // define first 2 number length
            for(int len2 = 1; n - len1 - len2 >= Math.max(len1, len2); len2++)
                if(isValid(str, len1 - 1, len1 + len2 - 1))
                    return true;
        return false;
    }


    //for str, given first number is [0,...,i], second number is [i+1,...,j]. return true if this string is additive number by these 2 start number
    public static boolean isValid(String str, int i, int j) {
        // if number is greater than 0, and starts with 0, return false. such as 012, 04. But 0 is valid
        if(str.charAt(i + 1) == '0' && j - i > 1 || i > 0 && str.charAt(0) == '0')
            return false;
        int start = 0, n = str.length();
        while (j < n - 1) {
            Long num1 = Long.parseLong(str.substring(start, i + 1));
            Long num2 = Long.parseLong(str.substring(i + 1, j + 1));
            Long num = num1 + num2;
            int size = (int)Math.log10(num) + 1;
            if(j + size < n && num.toString().equals(str.substring(j + 1, j + size + 1))) {
                start = i + 1;
                i = j;
                j += size;
            }
            else
                return false;
        }
        if(j == n - 1)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
//        String str = "112334";
//        String str = "199100199";
//        String str = "120122436";
//        String str = "12012122436";
        String str = "0235813";
        System.out.println(isAdditiveNumber(str));
//        System.out.println(isValid("str", 0, 2));
    }

}
