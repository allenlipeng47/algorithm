package com.pli.project.algorithm.ms;

import com.pli.project.algorithm.util.TreeNode;

/**
 * Created by lipeng on 2016/3/17.
 */
public class BinaryTreeSerialization {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null,";
        }
        else {
            return String.valueOf(root.val) + "," + serialize(root.left) + serialize(root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        int[] i = new int[1];
        return deserializeHelper(strs, i);
    }

    public TreeNode deserializeHelper(String[] strs, int[] i) {
        String str = strs[i[0]];
        if (str.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(str));
        i[0]++;
        node.left = deserializeHelper(strs, i);
        i[0]++;
        node.right = deserializeHelper(strs, i);
        return node;
    }

}
