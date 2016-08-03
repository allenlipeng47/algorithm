package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lipeng on 2016/8/2.
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 * A recursive practice.
 */
public class l95UniqueBstII {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return helper(n, 1, n);
    }

    public List<TreeNode> helper(int n, int start, int end) {
        if (start > end) {
            return Collections.singletonList(null);
        }
        List<TreeNode> ans = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = helper(n, start, i - 1);
            List<TreeNode> right = helper(n, i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    ans.add(node);
                }
            }
        }
        return ans;
    }


}
