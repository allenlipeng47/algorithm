package com.pli.project.algorithm.exercise2014;

import com.pli.project.algorithm.exercise2014.util.MyInteger;
import com.pli.project.algorithm.exercise2014.util.Tree;


public class ConstructBSTPreOrder {

	public static void main(String[] args) {
		int[] array = {4,3,1,2,7,5,8};
		MyInteger pos = new MyInteger(0);
		Tree tree = constructBSTByPreOrder(array, pos, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(tree);
	}
	
	public static Tree constructBSTByPreOrder(int[] array, MyInteger pos, int min, int max){
		if(array==null||pos.i>=array.length){
			return null;
		}
		if(array[pos.i]<min||array[pos.i]>max){
			return null;
		}
		Tree tree = new Tree(array[pos.i]);
		pos.i++;
		tree.left = constructBSTByPreOrder(array, pos, min, tree.value);
		tree.right = constructBSTByPreOrder(array, pos, tree.value, max);
		return tree;
	}
	
	
}



