package com.pli.project.algorithm.tree;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lipeng on 2015/8/1.
 */
public class TreeSerializing {

    public static String treeSerializing(Tree tree){
        Assert.assertNotNull(tree);
        StringBuffer result = new StringBuffer();
        Queue<Tree> queue = new LinkedList<Tree>();
        queue.add(tree);
        result.append(tree.value + " ");
        while(!queue.isEmpty()){
            Tree curr = queue.remove();
            result.append(curr.descendant.size() + " ");
            for(Tree child : curr.descendant){
                queue.add(child);
                result.append(child.value + " ");
            }
        }
        return result.toString();
    }

    public static Tree treeDeserializing(String str){
        Assert.assertNotNull(str);
        Queue<Tree> queue = new LinkedList<Tree>();
        int[] startPos = new int[1];
        int value = nextNum(str, startPos);
        Tree tree = new Tree(value);
        queue.add(tree);
        while(!queue.isEmpty()){
            Tree curr = queue.remove();
            int childSize = nextNum(str, startPos);
            while(childSize-- > 0){
                value = nextNum(str, startPos);
                Tree child = new Tree(value);
                curr.descendant.add(child);
                queue.add(child);
            }
        }
        return tree;
    }

    public static int nextNum(String str, int[] startPos){
        Assert.assertNotNull(str);
        if(startPos[0]>=str.length() || startPos[0]<0) {
            return -1;
        }
        int endPos = str.indexOf(" ", startPos[0]);
        int num;
        if(endPos != -1) {
            num = Integer.valueOf(str.substring(startPos[0], endPos));
            startPos[0] = ++endPos;
        }
        else {
            num = Integer.valueOf(str.substring(startPos[0], str.length()));
            startPos[0] = endPos;
        }
        return num;
    }

    static class Tree{
        public int value;
        ArrayList<Tree> descendant;
        public Tree(int value){
            this.value = value;
            descendant = new ArrayList<Tree>();
        }
    }

    public static Tree getTree1(){
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
        t7.descendant.add(t9); t7.descendant.add(t10);
        t3.descendant.add(t5); t3.descendant.add(t6); t3.descendant.add(t7); t3.descendant.add(t8);
        t1.descendant.add(t2); t1.descendant.add(t3); t1.descendant.add(t4);
        return t1;
    }

    public static Tree getTree2(){
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
        t1.descendant.add(t2); t1.descendant.add(t3); t1.descendant.add(t4);
        t2.descendant.add(t5); t2.descendant.add(t6);
        t2.descendant.add(t7); t2.descendant.add(t8); t2.descendant.add(t9); t2.descendant.add(t10);
        t6.descendant.add(t11);
        return t1;
    }

    public static void main(String[] args) {
        Tree tree = getTree2();
        String serializingStr = treeSerializing(tree);
        System.out.println(serializingStr);
        tree = treeDeserializing(serializingStr);
    }

}
