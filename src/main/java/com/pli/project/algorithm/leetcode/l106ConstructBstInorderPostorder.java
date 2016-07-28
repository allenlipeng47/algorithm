package com.pli.project.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by lipeng on 2016/7/27.
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * Each time, use the last element in postorder is the pivot. Find the pivot in inorder array.
 * A technique is to use hashmap to store <inorderValue, pos>. In this way, we can find the pivot in inorder array in O(1) time.
 */
public class l106ConstructBstInorderPostorder {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null) {
            return null;
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[0], i);
        }
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, hm);
    }

    private static TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd, HashMap<Integer, Integer> hm) {
        if (inStart == inEnd) {
            return new TreeNode(inorder[inStart]);
        }
        if (inStart > inEnd) {
            return null;
        }
        int inMid = hm.get(postorder[postEnd]);
        TreeNode node = new TreeNode(inorder[inMid]);
        node.left = helper(inorder, postorder, inStart, inMid - 1, postStart, postEnd - (inEnd - inMid) - 1, hm);
        node.right = helper(inorder, postorder, inMid + 1, inEnd, postEnd - (inEnd - inMid), postEnd - 1, hm);
        return node;
    }

    public static void main(String[] args) {
        int[] inorder = {2, 1};
        int[] postorder = {2, 1};
        TreeNode node = buildTree(inorder, postorder);
        System.out.println();
    }
}
