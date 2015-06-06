package com.pli.project.algorithm.tree;

import com.pli.project.algorithm.hash.rollinghash.RollingHashQueue;
import com.pli.project.algorithm.util.Tree;

/**
 * Created by lipeng on 2015/6/2.
 */
public class FindPalindromeInBiTree {

    static boolean findPalindromeInTree(Tree tree){
        if(tree == null){
            return false;
        }
        TpData data = new TpData();
        data.q1.addFirst(tree.value);
        data.q2.addFirst(tree.value);
        data.depth++;
        if(tree.left!=null && findPalindromeInTreeUtil(tree.left, data)){
            return true;
        }
        if(tree.right !=null && findPalindromeInTreeUtil(tree.right, data)){
            return true;
        }
        return false;
    }


    static boolean findPalindromeInTreeUtil(Tree tree, TpData data){
        /* Modify first queue and second queue depending on odd/even of depth */
        data.depth++;
        if(data.depth % 2 == 1){
            data.q1.addLast(data.q2.getLast());
            data.q2.addFirst(tree.value);
        }
        else{
            data.q2.removeLast();
            data.q2.addFirst(tree.value);
        }
        /* Check q1 and q2 by rolling hash */
        if(tree.left==null && tree.right==null && data.depth > 1 && data.q1.equals(data.q2)){
            System.out.println(data.q1);
            return  true;
        }
        /* Find palindrome in left, right tree */
        if(tree.left!=null && findPalindromeInTreeUtil(tree.left, data)){
            return true;
        }
        if(tree.right !=null && findPalindromeInTreeUtil(tree.right, data)){
            return true;
        }
        /* No palindrome found in both left, right, backtrace */
        if(data.depth % 2 == 1) {
            data.q1.removeLast();
            data.q2.removeFirst();
        }
        else {
            data.q2.removeFirst();
            data.q2.addLast(data.q1.getLast());
        }
        data.depth--;
        return false;
    }

    /** TreePalindromeData**/
    static class TpData {
        RollingHashQueue q1;
        RollingHashQueue q2;
        int depth;
        public TpData(){
            q1 = new RollingHashQueue();
            q2 = new RollingHashQueue();
            depth = 0;
        }
    }

    public static void main(String[] args) {
        Tree t1 = new Tree(1);
        Tree t2 = new Tree(6);
        Tree t3 = new Tree(4);
        Tree t4 = new Tree(2);
        Tree t5 = new Tree(3);
        Tree t6 = new Tree(2);
        Tree t7 = new Tree(5);
        Tree t8 = new Tree(1);
        t1.left = t2; t1.right = t4;
        t2.right = t3;
        t4.right = t5;
        t5.right = t6;
        t6.left = t7; t6.right = t8;
        findPalindromeInTree(t1);
    }
}