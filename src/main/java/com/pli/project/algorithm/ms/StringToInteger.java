package com.pli.project.algorithm.ms;

/**
 * Created by lipeng on 2016/3/18.
 */
public class StringToInteger {

    public int getInteger(String str) {
        int ans = 0;
        int sign = 1;
        int i = 0;
        if (str.charAt(0) == '-') {
            sign = -1;
            i = 1;
        }
        for (; i < str.length(); i++) {
            char ch = str.charAt(i);
            ans = ans * 10 + (ch - '0');
        }
        return ans * sign;
    }

    public static void main(String[] args) {
        StringToInteger s = new StringToInteger();
        System.out.println(s.getInteger("-1234"));
    }

}
