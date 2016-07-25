package com.pli.project.algorithm.leetcode;

import java.util.List;

/**
 * Created by lipeng on 2016/7/24.
 * https://leetcode.com/problems/triangle/
 * dp problem.
 */
public class l120Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int num = Integer.MAX_VALUE;    // update (i, j) by (i - 1, j - 1) and (i - 1, j)
                if (j > 0) {
                    num = Math.min(num, triangle.get(i - 1).get(j - 1));
                }
                if (j < triangle.get(i - 1).size()) {
                    num = Math.min(num, triangle.get(i - 1).get(j));
                }
                int curr = triangle.get(i).get(j);
                triangle.get(i).set(j, curr + num);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i : triangle.get(triangle.size() - 1)) {
            ans = Math.min(ans, i);
        }
        return ans;
    }


}
