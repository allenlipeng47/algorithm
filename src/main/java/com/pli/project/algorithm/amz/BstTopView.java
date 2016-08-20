package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * Created by lipeng on 2016/8/19.
 * https://www.hackerrank.com/challenges/tree-top-view?h_r=next-challenge&h_v=zen
 * Level order traversal. Need an auxiliary structure to store horizontal level.
 */
public class BstTopView {

    class TNode {
        TreeNode node;
        int horizonLevel;
        public TNode(TreeNode node, int horizonLevel) {
            this.node = node;
            this.horizonLevel = horizonLevel;
        }
    }

    void top_view(TreeNode root) {
        Deque<TNode> queue = new ArrayDeque();
        Deque<TreeNode> ans = new ArrayDeque<>();
        ans.add(root);
        int left = 0, right = 0;
        queue.add(new TNode(root, 0));
        while (!queue.isEmpty()) {
            Deque<TNode> queue2 = new ArrayDeque<>();
            for (TNode tnode : queue) {
                if (tnode.node == null) {
                    continue;
                }
                if (tnode.horizonLevel < left) {
                    ans.addFirst(tnode.node);
                    left--;
                }
                if (tnode.horizonLevel > right) {
                    ans.addLast(tnode.node);
                    right++;
                }
                queue2.add(new TNode(tnode.node.left, tnode.horizonLevel - 1));
                queue2.add(new TNode(tnode.node.right, tnode.horizonLevel + 1));
            }
            queue = queue2;
        }
        for (TreeNode node : ans) {
            System.out.print(node.val + " ");
        }
    }

}
