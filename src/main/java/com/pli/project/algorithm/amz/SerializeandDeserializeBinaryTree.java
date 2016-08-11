package com.pli.project.algorithm.amz;

import com.pli.project.algorithm.util.TreeNode;


/**
 * Created by lipeng on 2016/8/10.
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeandDeserializeBinaryTree {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return String.valueOf(root.val) + " " + serialize(root.left) + " " + serialize(root.right);
    }

    int desPos;

    public TreeNode deserialize(String data) {
        desPos = -1;
        return desHelper(data.split(" "));
    }

    private TreeNode desHelper(String[] strs) {
        desPos++;
        if (strs[desPos].equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(strs[desPos]));
        node.left = desHelper(strs);
        node.right = desHelper(strs);
        return node;
    }

}
