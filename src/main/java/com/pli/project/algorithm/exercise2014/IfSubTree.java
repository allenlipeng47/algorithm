package com.pli.project.algorithm.exercise2014;

import com.pli.project.algorithm.util.MyBoolean;
import com.pli.project.algorithm.util.Tree;


public class IfSubTree {
	
	public static void main(String[] args) {
		Tree tree = Tree.getTree();
		Tree mainTree = new Tree(2);
		Tree subTree = new Tree(3);
		System.out.println(ifSubTree(tree, mainTree, subTree, new MyBoolean(false), new MyBoolean(false)));
		
	}
	
	/*
	 * 判断某一棵树是否是另外一棵树的子树
	 */
	public static boolean ifSubTree(Tree tree, Tree mainTree, Tree subTree, MyBoolean foundMainTree, MyBoolean compulsoryExit){
		if(tree==null){
			return false;
		}
		if(foundMainTree.bool){
			//以之前的遍历中已找到主树
			if(tree.value==subTree.value){
				return true;
			}
			return ifSubTree(tree.left, mainTree, subTree, foundMainTree, compulsoryExit)||
			ifSubTree(tree.right, mainTree, subTree, foundMainTree, compulsoryExit);
		}
		else{
			//在之前的遍历中还没找到主树
			if(tree.value==subTree.value){
				compulsoryExit.bool = true;
				return false;
			}
			if(tree.value==mainTree.value){
				//找到了主树
				foundMainTree.bool = true;
				return ifSubTree(tree.left, mainTree, subTree, foundMainTree, compulsoryExit)||
					ifSubTree(tree.right, mainTree, subTree, foundMainTree, compulsoryExit);
			}
			boolean foundLeft = ifSubTree(tree.left, mainTree, subTree, foundMainTree, compulsoryExit);
			if(foundLeft){
				return true;
			}
			if(compulsoryExit.bool||foundMainTree.bool){
				return false;
			}
			return ifSubTree(tree.right, mainTree, subTree, foundMainTree, compulsoryExit);
		}
	}
}
