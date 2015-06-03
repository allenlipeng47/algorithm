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
	 * �ж�ĳһ�����Ƿ�������һ����������
	 */
	public static boolean ifSubTree(Tree tree, Tree mainTree, Tree subTree, MyBoolean foundMainTree, MyBoolean compulsoryExit){
		if(tree==null){
			return false;
		}
		if(foundMainTree.bool){
			//��֮ǰ�ı��������ҵ�����
			if(tree.value==subTree.value){
				return true;
			}
			return ifSubTree(tree.left, mainTree, subTree, foundMainTree, compulsoryExit)||
			ifSubTree(tree.right, mainTree, subTree, foundMainTree, compulsoryExit);
		}
		else{
			//��֮ǰ�ı����л�û�ҵ�����
			if(tree.value==subTree.value){
				compulsoryExit.bool = true;
				return false;
			}
			if(tree.value==mainTree.value){
				//�ҵ�������
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
