package com.pli.project.algorithm.tree;

import com.pli.project.algorithm.util.Tree;

/**
 * Created by lipeng on 2015/11/30.
 * BST tree has its value. There should be a path in tree which has the maximum sum of value.
 * Find the maximum value
 */
public class LargestSumIncludingNegative {

    public static int getLargestSum(Tree tree) {
        if(tree==null) {
            return 0;
        }
        SumRecord rec = new SumRecord();
        getLargestSumHelper(tree, rec);
        return Math.max(rec.sum, rec.sumOnNode);
    }

    public static void getLargestSumHelper(Tree tree, SumRecord rec) {
        if(tree==null) {
            return;
        }
        SumRecord left = new SumRecord();
        SumRecord right = new SumRecord();
        getLargestSumHelper(tree.left, left);
        getLargestSumHelper(tree.right, right);
        rec.sumOnNode = Math.max(left.sumOnNode, right.sumOnNode) + tree.value;
        rec.sum = Math.max(left.sumOnNode + right.sumOnNode + tree.value, Math.max(left.sum, right.sum));
    }

    public static void main(String[] args) {
        System.out.println(getLargestSum(Tree.getTree4()));
    }

    static class SumRecord {
        public int sumOnNode = 0;   //max value
        public int sum = 0;
    }

}
