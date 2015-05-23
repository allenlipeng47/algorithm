package com.pli.project.algorithm.exercise2014;

import com.pli.project.algorithm.exercise2014.util.MyInteger;
import com.pli.project.algorithm.exercise2014.util.Tree;


/*
 * Algorithms for Interview, 10.12
 * H, B, F, null, null, E, A, null, null, null, C, null, D, null, G, I, null, null, null
 */

public class ConstructTreeByPreOrder2 {
	
	
	public static void main(String[] args){
		char[] pre = {'H','B','F','0','0','E', 'A','0','0','0','C','0','D','0','G','I','0','0','0'};
		MyInteger i = new MyInteger(0);
		Tree tree = constructTreeByPreOrder2(pre, i);
		preOrderPrintTree(tree);
		System.out.println();
	}
	
	public static Tree constructTreeByPreOrder(char[] pre, MyInteger myInteger){
		int i = myInteger.i;
		if(i>=pre.length){
			return null;
		}
		if(pre[i]=='0'){
			myInteger.i++;
			return null;
		}
		Tree tree = new Tree(String.valueOf(pre[i]));
		myInteger.i++;
		tree.left = constructTreeByPreOrder(pre, myInteger);
		tree.right = constructTreeByPreOrder(pre, myInteger);
		return tree;
	}
	
	public static Tree constructTreeByPreOrder2(char[] pre, MyInteger myInteger){
		if(myInteger.i>=pre.length){
			return null;
		}
		if(pre[myInteger.i]=='0'){
			myInteger.i++;
			return null;
		}
		else{
			Tree tree = new Tree(pre[myInteger.i]);
			myInteger.i++;
			tree.left = constructTreeByPreOrder2(pre, myInteger);
			tree.right = constructTreeByPreOrder2(pre, myInteger);
			return tree;
		}
	}
	
	public static void preOrderPrintTree(Tree tree){
		if(tree==null)
			return;
		System.out.print(tree.value+" ");
		preOrderPrintTree(tree.left);
		preOrderPrintTree(tree.right);
	}
}