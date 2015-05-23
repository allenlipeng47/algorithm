package com.pli.project.algorithm.exercise2014;

import com.pli.project.algorithm.exercise2014.util.MyInteger;
import com.pli.project.algorithm.exercise2014.util.Tree;


/*
 * http://www.geeksforgeeks.org/construct-a-special-tree-from-given-preorder-traversal/
 * Input:  pre[] = {10, 30, 20, 5, 15},  preLN[] = {'N', 'N', 'L', 'L', 'L'}
 * Output: Root of following tree
          10
         /  \
        30   15
       /  \
      20   5
 */

public class ConstructTreeByPreOrder {
	
	
	public static void main(String[] args){
		int[] pre = {10,30,20,5,15};
		char[] preLN = {'N','N','L','L','L'};
		MyInteger i = new MyInteger(0);
		Tree tree = constructTreeByPreOrder2(pre, preLN, i);
		System.out.println();
	}
	
	public static Tree constructTreeByPreOrder(int[] pre, char[] preLN, MyInteger myInteger){
		int i = myInteger.i;
		if(i>=pre.length){
			return null;
		}
		Tree tree = new Tree(pre[i]);
		myInteger.i++;
		if(preLN[i]=='N'){
			tree.left = constructTreeByPreOrder(pre, preLN, myInteger);
			tree.right = constructTreeByPreOrder(pre, preLN, myInteger);
		}
		return tree;
	}
	
	public static Tree constructTreeByPreOrder2(int[] pre, char[] preLN, MyInteger myInteger){
		if(myInteger.i>=pre.length){
			return null;
		}
		Tree tree = new Tree(pre[myInteger.i]);
		myInteger.i++;
		if(preLN[myInteger.i-1]=='N'){
			tree.left = constructTreeByPreOrder2(pre, preLN, myInteger);
			tree.right = constructTreeByPreOrder2(pre, preLN, myInteger);
		}
		return tree;
	}
}
