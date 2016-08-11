package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.util.TreeNode;
import org.junit.Test;

/**
 * Created by lipeng on 2016/8/10.
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeandDeserializeBinaryTreeTest {

    @Test
    public void test1() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2; t1.right = t3;
        SerializeandDeserializeBinaryTree s = new SerializeandDeserializeBinaryTree();
        assert s.serialize(t1).equals("1 2 # # 3 # #");
    }

    @Test
    public void test2() {
        SerializeandDeserializeBinaryTree s = new SerializeandDeserializeBinaryTree();
        TreeNode node = s.deserialize("1 2 # # 3 # #");
        assert node.val == 1;
        assert node.left.val == 2;
        assert node.right.val == 3;
        assert node.left.left == null;
        assert node.left.right == null;
        assert node.right.left == null;
        assert node.right.right == null;
    }



}
