package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.util.TreeNode;
import org.junit.Test;

/**
 * Created by lipeng on 2016/8/10.
 */
public class LowestCommonAncestorofBstTest {

    @Test
    public void test1() {
        TreeNode t1 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(0);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(9);
        TreeNode t8 = new TreeNode(3);
        TreeNode t9 = new TreeNode(5);
        t1.left = t2; t1.right = t3; t2.left = t4; t2.right = t5;
        t3.left = t6; t3.right = t7;
        t5.left = t8; t5.right = t9;
        LowestCommonAncestorofBst l = new LowestCommonAncestorofBst();
        assert l.lowestCommonAncestor(t1, t5, t7).val == t1.val;
        assert l.lowestCommonAncestor(t3, t6, t7).val == t3.val;
    }

    @Test
    public void test2() {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        t1.left = t2;
        LowestCommonAncestorofBst l = new LowestCommonAncestorofBst();
        assert l.lowestCommonAncestor(t1, t2, t1).val == 2;
    }

}
