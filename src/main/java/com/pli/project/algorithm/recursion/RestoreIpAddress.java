package com.pli.project.algorithm.recursion;

import com.pli.project.algorithm.exercise2014.IntegerSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lipeng on 2016/1/17.
 * http://www.lintcode.com/en/problem/restore-ip-addresses/
 */
public class RestoreIpAddress {

    public static ArrayList<String> restoreIpAddresses(String s) {
        // Write your code here
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> curr = new ArrayList<String>();
        restoreHelper(s, 0, list, curr);
        return list;
    }


    public static void restoreHelper(String s, int pos, List<String> list, List<String> curr) {
        if(curr.size() >= 4 && pos >= s.length()) {
            String ans = curr.get(0);
            for(int i = 1; i < curr.size(); i++)
                ans = ans + "." + curr.get(i);
            list.add(ans);
        }
        else if(curr.size() < 4 && pos < s.length()) {
            if (s.charAt(pos) == '0') { // 0 should be taken care of specially.
                curr.add("0");
                restoreHelper(s, pos + 1, list, curr);
                curr.remove(curr.size() - 1);
                return;
            }
            int n = s.length();
            for (int i = 1; i < 4 && pos + i <= n; i++) {
                String value = s.substring(pos, pos + i);
                if (Integer.valueOf(value) > 255)
                    continue;
                curr.add(value);
                restoreHelper(s, pos + i, list, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String ip = "010010";
        List<String> list = restoreIpAddresses(ip);
        System.out.println(list);
    }
}
