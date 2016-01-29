package com.pli.project.algorithm.numbertheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lipeng on 2016/1/26.
 * http://www.cnblogs.com/jcliBlogger/p/4713146.html
 */
public class StrobogrammaticII2 {

    public static final char[][] chs = {{'6', '9'}, {'9', '6'}, {'1', '1'}, {'8', '8'}, {'0', '0'}};

    public static List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<String>();
        if ((n & 1) == 1) {
            findHelper(ans, new StringBuffer("1"), 1, n);
            findHelper(ans, new StringBuffer("0"), 1, n);
            findHelper(ans, new StringBuffer("8"), 1, n);
        }
        else {
            findHelper(ans, new StringBuffer(), 0, n);
        }
        return ans;
    }

    public static void findHelper(List<String> ans, StringBuffer buf, int pos, int n) {
        if (buf.length() >= n && buf.charAt(0) != '0') {
            ans.add(buf.toString());
            return;
        }
        for (int i = 0; i < 4; i++) {
            buf.insert(0, chs[i][0]);
            buf.append(chs[i][1]);
            findHelper(ans, buf, pos + 2, n);
            buf.deleteCharAt(0);
            buf.deleteCharAt(buf.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(findStrobogrammatic(3));
    }
}
