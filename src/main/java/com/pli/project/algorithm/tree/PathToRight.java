package com.pli.project.algorithm.tree;

import com.pli.project.algorithm.util.Tree;

import java.util.ArrayList;

/**
 * Created by lipeng on 2015/12/12.
 * https://www.careercup.com/question?id=5706578317541376
 * Write a function to return a path from a given node of a Binary tree to the node on its right.
 Each node contains a left pointer, a right pointer and a parent pointer
 The root node is not provided, the tree is not balanced, the tree is not a Binary search tree
 */
public class PathToRight {

    public static ArrayList<Integer> pathToRight(Tree node) {
        int level = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        Tree pre = node;
        Tree curr = pre.parent;
        ans.add(node.value);
        while (curr.right == null || curr.right == pre) {
            ans.add(curr.value);
            pre = curr;
            curr = curr.parent;
            level++;
        }
        ans.add(curr.value);
        pre = curr;
        curr = curr.right;
        ans.add(curr.value);
        while (level > 0) {
            if (curr.parent == pre) { // just enter
                if (curr.left != null) {
                    pre = curr;
                    curr = curr.left;
                    level--;
                    ans.add(curr.value);
                }
                else if (curr.right != null) {
                    pre = curr;
                    curr = curr.right;
                    level--;
                    ans.add(curr.value);
                }
                else {
                    pre = curr;
                    curr = curr.parent;
                    level++;
                    ans.remove(ans.size() - 1);
                }
            }
            else if (pre == curr.left) { // return from left, try right first, then try parent
                if (curr.right != null) {
                    pre = curr;
                    curr = curr.right;
                    level--;
                    ans.add(curr.value);
                }
                else {
                    pre = curr;
                    curr = curr.parent;
                    level++;
                    ans.remove(ans.size() - 1);
                }
            }
            else {  // return from right.
                pre = curr;
                curr = curr.parent;
                level++;
                ans.remove(ans.size() - 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Tree t1 = new Tree(1);
        Tree t2 = new Tree(2);
        Tree t3 = new Tree(3);
        Tree t4 = new Tree(4);
        Tree t5 = new Tree(5);
        Tree t6 = new Tree(6);
        Tree t7 = new Tree(7);
        Tree t8 = new Tree(8);
        Tree t9 = new Tree(9);
        Tree t10 = new Tree(10);
        Tree t11 = new Tree(11);
        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5; t2.parent = t1;
        t5.left = t8; t5.parent = t2;
        t3.left = t6; t3.right = t7; t3.parent = t1;
        t6.parent = t3;
        t7.left = t9; t7.right = t10; t7.parent = t3;
        t8.parent = t5;
        t9.parent = t7;
        t10.left = t11;
        t11.parent = t10;
        System.out.println(pathToRight(t5));
    }

}