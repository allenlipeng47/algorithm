package com.pli.project.algorithm.amz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipeng on 2016/8/16.
 * https://leetcode.com/problems/gray-code/
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        for (int i = 1, base = 1; i <= n; i++, base = base << 1) {
            for (int j = ans.size() - 1; j >= 0; j--) {
                ans.add(ans.get(j) | base);
            }
        }
        return ans;
    }

}
