package com.pli.project.algorithm;

import com.pli.project.algorithm.exercise2014.IntegerSet;
import com.pli.project.algorithm.util.TreeNode;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import sun.awt.IconInfo;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by lipeng on 2015/12/12.
 */
public class test {

    public static int myAtoi(String str) {
        int index = 0, ans = 0, sign = 1, len = str.length();
        while (index < len && str.charAt(index) == ' ') {
            index++;
        }
        if (index < len && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
            sign = str.charAt(index++) == '-' ? -1 : 1;
        }
        while (index < len) {
            char ch = str.charAt(index);
            if (ch < '0' || ch > '9') {
                break;
            }
            int base = ch - '0';
            if (Integer.MAX_VALUE / 10 < ans || Integer.MAX_VALUE / 10 == ans && Integer.MAX_VALUE % 10 <= base) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + base;
            index++;
        }
        return ans * sign;
    }


    public static void main(String[] args) {
//        int[] arr = {3, 1, 1, 2, 5, 1};
        System.out.println(myAtoi("-2147483648"));
//        System.out.println(Arrays.toString(arr));
        System.out.println(Integer.MIN_VALUE);
    }


}