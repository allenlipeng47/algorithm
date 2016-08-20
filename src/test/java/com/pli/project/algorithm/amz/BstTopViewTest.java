package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.util.TreeNode;
import org.junit.Test;

/**
 * Created by lipeng on 2016/8/19.
 */
public class BstTopViewTest {

    @Test
    public void test1() {
        BstTopView b = new BstTopView();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5;
        t5.right = t6;
        t6.right = t7;
        b.top_view(t1);
    }

}
