package com.pli.project.algorithm.amz;

/**
 * Created by lipeng on 2016/8/24.
 * From A -> 1, AB -> 28
 */
public class Excel1 {

    public int titleToNumber(String s) {
        int ans = 0, base = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            ans += (ch - 'A' + 1) * base;
            base *= 26;
        }
        return ans;
    }

}
