package com.pli.project.algorithm.leetcode;

import java.util.HashMap;

/**
 * Created by lipeng on 2016/7/27.
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Each time, use the first element in preorder is the pivot. Find the pivot in inorder array.
 * A technique is to use hashmap to store <inorderValue, pos>. In this way, we can find the pivot in inorder array in O(1) time.
 */
public class l105ConstructBstInorderPreorder {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null) {
            return null;
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        return helper(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1, hm);
    }

    private static TreeNode helper(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart, int preEnd, HashMap<Integer, Integer> hm) {
        if (inStart > inEnd) {
            return null;
        }
        int inMid = hm.get(preorder[preStart]);
        TreeNode node = new TreeNode(inorder[inMid]);
        node.left = helper(inorder, preorder, inStart, inMid - 1, preStart + 1, preStart + inMid - inStart, hm);
        node.right = helper(inorder, preorder, inMid + 1, inEnd, preStart + inMid - inStart + 1, preEnd, hm);
        return node;
    }

    public static void main(String[] args) {
        int[] inorder = {1, 2, 3};
        int[] preorder = {2, 3, 1};
        System.out.println();
    }
}
