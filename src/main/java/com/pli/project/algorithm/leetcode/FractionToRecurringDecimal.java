package com.pli.project.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lipeng on 2016/4/20.
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 */
public class FractionToRecurringDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuffer ans = new StringBuffer();
        if (numerator == 0) {
            return "0";
        }
        ans.append((numerator >= 0) ^ (denominator >= 0) ? "-" : "");
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        long remaining = n % d;
        ans.append(n / d);
        if (remaining == 0) {
            return ans.toString();
        }
        ans.append(".");
        Map<Long, Integer> remainingHs = new HashMap<>();
        int i = ans.length();
        while (remaining != 0) {
            if (remainingHs.containsKey(remaining)) {
                int pos = remainingHs.get(remaining);
                ans.insert(pos, "(").append(")");
                break;
            }
            remainingHs.put(remaining, i++);
            remaining *= 10;
            ans.append(remaining / d);  // in the loop, result should append remaining / d
            remaining = remaining % d;  // update remaining
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String ans = fractionToDecimal(1, -5);
        System.out.println(ans);
    }


}
