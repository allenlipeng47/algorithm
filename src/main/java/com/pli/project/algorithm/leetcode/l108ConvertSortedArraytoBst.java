package com.pli.project.algorithm.leetcode;

/**
 * Created by lipeng on 2016/7/27.
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class l108ConvertSortedArraytoBst {

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private static TreeNode helper(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        else if (start > end) {
            return null;
        }
        int mid = (start + end + 1) / 2;    // need to test mid for [0, 1, 2], [0], [3, 4, 5, 6, 7], [3, 4, 5, 6, 7, 8] etc.
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, start, mid - 1);
        node.right = helper(nums, mid + 1, end);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        TreeNode node = sortedArrayToBST(nums);
        System.out.println();
    }
}
