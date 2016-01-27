package com.pli.project.algorithm.numbertheory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/1/26.
 * http://www.cnblogs.com/jcliBlogger/p/4739442.html
 * This is a more comfortable way.
 */
public class StrobogrammaticIII {

    public static final char[][] chs = {{'6', '9'}, {'9', '6'}, {'1', '1'}, {'8', '8'}, {'0', '0'}};

    public static int findStrobogrammatic(String lo, String high) {
        int[] ans = new int[1];
        int n = high.length();
        findHelper(ans, new StringBuffer("1"), 1, n, lo, high);
        findHelper(ans, new StringBuffer("0"), 1, n, lo, high);
        findHelper(ans, new StringBuffer("8"), 1, n, lo, high);
        findHelper(ans, new StringBuffer(), 0, n, lo, high);
        return ans[0];
    }

    public static void findHelper(int[] ans, StringBuffer buf, int pos, int n, String lo, String high) {
        if (buf.length() > n)
            return;
        String potential = buf.toString();
        if (buf.length() > 0 && buf.charAt(0) != '0' && compare(potential, lo) >= 0 && compare(potential, high) <= 0) {
            ans[0]++;
            return;
        }
        for (int i = 0; i <= 4; i++) {
            buf.insert(0, chs[i][0]);
            buf.append(chs[i][1]);
            findHelper(ans, buf, pos + 2, n, lo, high);
            buf.deleteCharAt(0);
            buf.deleteCharAt(buf.length() - 1);
        }
    }

    public static int compare(String str1, String str2) {
        if (str1.length() != str2.length())
            return str1.length() - str2.length();
        int n = str1.length();
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.charAt(i) - str2.charAt(i);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findStrobogrammatic("25", "1001"));
    }
}
