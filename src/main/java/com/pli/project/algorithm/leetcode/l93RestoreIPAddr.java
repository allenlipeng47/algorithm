package com.pli.project.algorithm.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/8/2.
 * https://leetcode.com/problems/restore-ip-addresses/
 * Loop i from 1 to 3, j from 1 to 3, k from 1 to 3.
 * Then check (s, i, j, k) is valid.
 */
public class l93RestoreIPAddr {

    public static List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                for (int k = 1; k < 4; k++) {
                    if (i <= s.length() && isValid(s.substring(0, i))
                            && i + j <= s.length() && isValid(s.substring(i, i + j))
                            && i + j + k <= s.length() && isValid(s.substring(i + j, i + j + k))
                            && isValid(s.substring(i + j + k, s.length()))) {
                        ans.add(s.substring(0, i) + "." + s.substring(i, i + j) + "." +  s.substring(i + j, i + j + k) + "."
                                + s.substring(i + j + k, s.length()));
                    }
                }
            }
        }
        return ans;
    }

    public static boolean isValid(String s) {
        if (s.length() == 0 || s.length() > 3) {
            return false;
        }
        int i = Integer.valueOf(s);
        if (s.charAt(0) == '0' && s.length() > 1 || Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> list = restoreIpAddresses("1111");
        System.out.println(list);
    }


}
