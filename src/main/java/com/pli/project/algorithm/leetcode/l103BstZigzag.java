
package com.pli.project.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lipeng on 2016/7/27.
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class l103BstZigzag {

    // when entering the queue, it is always normal order. Only control how the element coming out of queue.
    public static List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        boolean reverse = false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<TreeNode> currQueue = new LinkedList<>();
            List<Integer> currAns = new ArrayList<>();
            if (reverse) {  // from last to first
                while (!queue.isEmpty()) {
                    TreeNode currNode = queue.removeLast();
                    currAns.add(currNode.val);
                    if (currNode.right != null) {
                        currQueue.addFirst(currNode.right);
                    }
                    if (currNode.left != null) {
                        currQueue.addFirst(currNode.left);
                    }
                }
            }
            else {
                while (!queue.isEmpty()) {
                    TreeNode currNode = queue.removeFirst();
                    currAns.add(currNode.val);
                    if (currNode.left != null) {
                        currQueue.addLast(currNode.left);
                    }
                    if (currNode.right != null) {
                        currQueue.addLast(currNode.right);
                    }
                }
            }
            ans.add(currAns);
            queue = currQueue;
            reverse = !reverse;
        }
        return ans;
    }

    // DFS solution. Initial root level is 0.
    // if level % 2 == 0, sequential order
    // if level % 2 == 1, reverse order
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        zigzagHelper(root, ans, 0);
        return ans;
    }

    private void zigzagHelper(TreeNode root, List<List<Integer>> ans, int level) {
        if (root == null) {
            return;
        }
        if (level >= ans.size()) {
            ans.add(new LinkedList<>());
        }
        LinkedList<Integer> curr = (LinkedList)ans.get(level);
        if (level % 2 == 0) {
            curr.addLast(root.val);
        }
        else {
            curr.addFirst(root.val);
        }
        zigzagHelper(root.left, ans, level + 1);
        zigzagHelper(root.right, ans, level + 1);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        t1.left = t2; t1.right = t3;
        t3.left = t4; t3.right = t5;
        t4.left = t6; t4.right = t7;
        t5.left = t8; t5.right = t9;
        System.out.println(zigzagLevelOrder1(t1));
    }


}
