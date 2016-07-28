package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lipeng on 2016/7/27.
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class l107LevelOrderTraverse {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> tmpQueue = new LinkedList<>();
            List<Integer> currAns = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode currNode = queue.remove(0);
                currAns.add(currNode.val);
                if (currNode.left != null) {
                    tmpQueue.add(currNode.left);
                }
                if (currNode.right != null) {
                    tmpQueue.add(currNode.right);
                }
            }
            ans.addFirst(currAns);
            queue = tmpQueue;
        }
        return ans;
    }


}
