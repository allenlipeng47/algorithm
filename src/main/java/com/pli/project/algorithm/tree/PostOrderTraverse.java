package com.pli.project.algorithm.tree;

import java.util.Stack;

/**
 * Created by lipeng on 2015/9/30.
 */
public class PostOrderTraverse {

    public static void buildPostOrderTraverseThread(TreeManager tm){
        if(tm==null||tm.tree==null){
            return;
        }
        Stack<Tree> stack = new Stack();
        Tree tree = tm.tree;
        stack.add(tree);
        Tree pre = tm.postTraversalHead;
        while(!stack.empty()){
            Tree curr = stack.peek();
            while(curr.left!=null&&!curr.left.visited){
                stack.add(curr.left);
                curr = curr.left;
            }
            if(curr.right==null||curr.right.visited){
                pre.successor = curr;
                pre = curr;
                curr.visited = true;
                stack.pop();
            }
            else{
                stack.add(curr.right);
            }
        } //while
    }

    public static void convertToSumTree(TreeManager tm) {
        Tree curr = tm.postTraversalHead.successor;
        while(curr != null) {
            int newValue = 0;
            if(curr.left!=null) {
                newValue = newValue + curr.left.value + curr.left.oldValue;
            }
            if(curr.right!=null) {
                newValue = newValue + curr.right.value + curr.right.oldValue;
            }
            curr.oldValue = curr.value;
            curr.value = newValue;
            curr = curr.successor;
        }
    }

    public static void postOrderTraversalByThread(TreeManager tm) {
        Tree curr = tm.postTraversalHead.successor;
        while(curr != null) {
            System.out.println(curr.value);
            curr = curr.successor;
        }
    }

    public static void main(String[] args) {
        TreeManager tm = getTree2();
        buildPostOrderTraverseThread(tm);
        convertToSumTree(tm);
        postOrderTraversalByThread(tm);
    }

    static class Tree{
        public Tree(int value){
            this.value = value;
        }
        public Tree left;
        public Tree right;
        public int value;
        public Tree successor;
        public boolean visited = false;
        public int oldValue; //After sum tree calculation, value will be updated, but need to save old value for parent calculation.
        public String toString(){
            return String.valueOf(value);
        }
    }

    static class TreeManager{
        Tree tree;
        Tree postTraversalHead;
        public TreeManager(Tree tree){
            this.tree = tree;
            postTraversalHead = new Tree(-1);
        }
    }

    public static TreeManager getTree2(){
        Tree t1 = new Tree(10);
        Tree t2 = new Tree(-2);
        Tree t3 = new Tree(6);
        Tree t4 = new Tree(8);
        Tree t5 = new Tree(-4);
        Tree t6 = new Tree(7);
        Tree t7 = new Tree(5);
        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5;
        t3.left = t6; t3.right = t7;
        return new TreeManager(t1);
    }

    public static TreeManager getTree1(){
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
        Tree t12 = new Tree(12);
        Tree t13 = new Tree(13);
        Tree t14 = new Tree(14);
        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5;
        t3.left = t6; t3.right = t7;
        t5.left = t8;
        t6.right = t9;
        t8.right = t10;
        t9.left = t11;
        t10.left = t12; t10.right = t13;
        t11.right = t14;
        return new TreeManager(t1);
    }

}