package com.pli.project.algorithm.exercise2014;

import com.pli.project.algorithm.exercise2014.util.MyInteger;
import com.pli.project.algorithm.exercise2014.util.Tree;


public class BuildSumTree {
	
	public static void main(String[] args) {
//		Tree tree = Tree.getSumTree();
//		convertToSumTree(tree);
		
		Tree tree = Tree.getSumTree2();
		System.out.println(ifSumTree2(tree));
		System.out.println();
	}
	
	/*
	 * http://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/
	 */
	public static int convertToSumTree(Tree tree){
		if(tree==null){
			return 0;
		}
		int lvalue = (tree.left==null)?0:tree.left.value;
		int rvalue = (tree.right==null)?0:tree.right.value;
		tree.value = convertToSumTree(tree.left) + convertToSumTree(tree.right) + lvalue + rvalue;
		return tree.value;
	}
	
	/*
	 * http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
	 */
	public static boolean ifSumTree(Tree tree, MyInteger sum){
		if(tree==null||(tree.left==null&&tree.right==null)){	//若为空，或叶节点，则返回true
			sum.i = 0;
			return true;
		}
		int lvalue = (tree.left==null)?0:tree.left.value;
		int rvalue = (tree.right==null)?0:tree.right.value;
		MyInteger lsum = new MyInteger(0);
		MyInteger rsum = new MyInteger(0);
		if(ifSumTree(tree.left, lsum)&&ifSumTree(tree.right, rsum)){
			sum.i = lsum.i + rsum.i + lvalue+rvalue;  
			boolean result = sum.i==tree.value;
			return result;
		}
		return false;
	}
	
	/*
	 * http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
	 */
	public static boolean ifSumTree2(Tree tree){
		if(tree==null||(tree.left==null&&tree.right==null)){	//若为空，或叶节点，则返回true
			return true;
		}
		int lvalue = (tree.left==null)?0:tree.left.value;
		int rvalue = (tree.right==null)?0:tree.right.value;
		if(ifSumTree2(tree.left)&&ifSumTree2(tree.right)){
			if(tree.value==lvalue*2+rvalue*2){
				return true;
			}
		}
		return false;
	}

}
