package com.pli.project.algorithm.exercise2014;

import com.pli.project.algorithm.exercise2014.util.Tree;


public class FindLargestBST {
	
	public static Tree getTree(){
		Tree t50 = new Tree(50);
		Tree t30 = new Tree(30);
		Tree t60 = new Tree(60);
		Tree t5 = new Tree(5);
		Tree t20 = new Tree(20);
		Tree t45 = new Tree(45);
		Tree t70 = new Tree(70);
		Tree t65 = new Tree(65);
		Tree t80 = new Tree(80);
		t50.left = t30;
		t50.right = t60;
		t30.left = t5;
		t30.right = t20;
		t60.left = t45;
		t60.right = t70;
		t70.left = t65;
		t70.right = t80;
		return t50;
	}
	
	public static Tree getTree2(){
		Tree t1 = new Tree(1);
		Tree t2 = new Tree(2);
		Tree t3 = new Tree(3);
		Tree t4 = new Tree(4);
		Tree t5 = new Tree(5);
		t5.left = t2;
		t5.right = t4;
		t2.left = t1;
		t2.right = t3;
		return t5;
	}
	
	/*
	 * Given a Binary Tree, write a function that returns the size of the 
		largest subtree which is also a Binary Search Tree (BST). If the 
		complete Binary Tree is BST, then return the size of whole tree.
	 * Input: 
		      5
		    /  \
		   2    4
		 /  \
		1    3
		
		Output: 3 
		The following subtree is the maximum size BST subtree 
		   2  
		 /  \
		1    3
		
		
		Input: 
		       50
		     /    \
		  30       60
		 /  \     /  \ 
		5   20   45    70
		              /  \
		            65    80
		Output: 5
		The following subtree is the maximum size BST subtree 
		      60
		     /  \ 
		   45    70
		        /  \
		      65    80
	 */
	public static void findLargestBST(Tree tree, LargestBSTData data){
		if(tree==null){
			data.size = 0;
			data.isBST = true;
			data.tree = null;
			return;
		}
		LargestBSTData ldata = new LargestBSTData();
		LargestBSTData rdata = new LargestBSTData();
		findLargestBST(tree.left, ldata);
		findLargestBST(tree.right, rdata);
		if(ldata.isBST&&rdata.isBST){	//左右子树都是BST时，判断本树与左右子树可否构成BST
			boolean lBST = false;	//记录本树与左子树构可成BST
			boolean rBST = false;	//记录本树与右子树构可成BST
			if(tree.left==null||tree.left.value<tree.value){
				lBST  = true;
			}
			if(tree.right==null||tree.right.value>tree.value){
				rBST  = true;
			}
			if(lBST&&rBST){	//可构成BST
				data.size = ldata.size + rdata.size + 1;
				data.tree = tree;
				data.isBST = true;
				return;
			}
		}
		//不可构成BST
		data.size = ldata.size>rdata.size?ldata.size:rdata.size;
		data.tree = ldata.size>rdata.size?ldata.tree:rdata.tree;
		data.isBST = false;
	}
	
	public static void main(String[] args) {
		Tree tree = getTree2();
		LargestBSTData data = new LargestBSTData();
		findLargestBST(tree, data);
		System.out.println(data.size);
	}
	
}

class LargestBSTData{
	public Tree tree;
	public boolean isBST;	//树本身就是BST
	public int size;
	public LargestBSTData(){}
}