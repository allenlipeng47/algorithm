package com.pli.project.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/1/2.
 */
public class GrayCode {

    public static List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(0);
        for(int i = 0, base = 1; i < n; i++, base = base << 1) {
            for (int j = ans.size() - 1; j >= 0; j--)
                ans.add(ans.get(j) | base);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> ans = grayCode(2);
        System.out.println(ans);
        System.out.println();
    }
}
