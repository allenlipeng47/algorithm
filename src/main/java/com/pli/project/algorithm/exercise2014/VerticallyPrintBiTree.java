package com.pli.project.algorithm.exercise2014;

import com.pli.project.algorithm.util.MyInteger;
import com.pli.project.algorithm.util.Tree;

/*
 * vertical traversal a binary tree
 * http://www.geeksforgeeks.org/print-binary-tree-vertical-order/
 */
public class VerticallyPrintBiTree {
	
	public static void main(String[] args) {
		Tree tree = Tree.getTree();
		MyInteger maxHori = new MyInteger(0);
		MyInteger minHori = new MyInteger(0);
		getMinMaxHori(tree, minHori, maxHori, 0);
		verticallyPrintBiTree(tree, minHori.i, maxHori.i);
	}
	
	/**
	 * 或者可以考虑用HashMap将每个点和Hori的值保存起来，<Hori, tree.val>，
	 * 并且记录最大值，最小值，遍历一遍后，从最小值到最大值打印
	 * @param tree
	 * @param minHori
	 * @param maxHori
	 * @param currHori
	 */
	public static void getMinMaxHori(Tree tree, MyInteger minHori, MyInteger maxHori, int currHori){
		if(tree==null){
			return;
		}
		if(currHori<minHori.i){
			minHori.i = currHori;
		}
		if(currHori>maxHori.i){
			maxHori.i = currHori;
		}
		getMinMaxHori(tree.left, minHori, maxHori, currHori-1);
		getMinMaxHori(tree.right, minHori, maxHori, currHori+1);
	}
	
	public static void verticallyPrint(Tree tree, int line_no, int currHori){
		if(tree==null){
			return;
		}
		if(line_no==currHori){
			System.out.print(tree.value + " ");
		}
		verticallyPrint(tree.left, line_no, currHori-1);
		verticallyPrint(tree.right, line_no, currHori+1);
	}
	
	public static void verticallyPrintBiTree(Tree tree, int minHori, int maxHori){
		for(int i=minHori;i<=maxHori;i++){
			verticallyPrint(tree, i, 0);
		}
	}

}
