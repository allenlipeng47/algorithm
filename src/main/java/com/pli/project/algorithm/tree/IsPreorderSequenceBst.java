package com.pli.project.algorithm.tree;

/**
 * Created by lipeng on 2016/1/24.
 */
public class IsPreorderSequenceBst {

    public static boolean verifyPreorder(int[] preorder) {
        return verifyPreorderHelper(preorder, 0, preorder.length - 1);
    }

    public static boolean verifyPreorderHelper(int[] preorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        // 1. find i where i is the first element after preorder[start] and greater than preorder[start]
        int i = start + 1;
        for (; i <= end && preorder[start] > preorder[i]; i++);
        // 2. check after i if there is any number less than preorder[start]
        for (int j = i + 1; j <= end; j++) {
            if (preorder[j] < preorder[start])
                return false;
        }
        return verifyPreorderHelper(preorder, start + 1, i - 1) && verifyPreorderHelper(preorder, i, end);
    }

    public static void main(String[] args) {
        int[] sequence = {5, 3, 1, 2, 7, 6, 8};
        System.out.println(verifyPreorder(sequence));
    }
}
