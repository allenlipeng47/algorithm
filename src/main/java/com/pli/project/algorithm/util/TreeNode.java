package com.pli.project.algorithm.util;



public class TreeNode {
	public TreeNode(int value){
		this.val = value;
	}
	public TreeNode(String value){
		this.valueString = value;
	}
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	public int val;
	public String valueString;
	public String toString(){
		return String.valueOf(val);
	}
	public static TreeNode getTree(){
		TreeNode t18 = new TreeNode(18);
		TreeNode t17 = new TreeNode(17);
		TreeNode t16 = new TreeNode(16);
		TreeNode t15 = new TreeNode(15);
		TreeNode t14 = new TreeNode(14);
		TreeNode t13 = new TreeNode(13);
		TreeNode t12 = new TreeNode(12);
		TreeNode t11 = new TreeNode(11);
		TreeNode t10 = new TreeNode(10);
		TreeNode t9 = new TreeNode(9);
		TreeNode t8 = new TreeNode(8);
		TreeNode t7 = new TreeNode(7);
		TreeNode t6 = new TreeNode(6);
		TreeNode t5 = new TreeNode(5);
		TreeNode t4 = new TreeNode(4);
		TreeNode t3 = new TreeNode(3);
		TreeNode t2 = new TreeNode(2);
		TreeNode t1 = new TreeNode(1);
		t8.left = t9;
		t6.left = t8;
		t5.right = t7;
		t4.left = t5;
		t4.right = t6;
		t2.left = t4;
		t1.left = t2;
		t1.right = t3;
		t6.right = t10;
		t3.left = t11;
		t3.right = t12;
		t12.left = t13;
		t12.right = t14;
		t13.left = t15;
		t13.right = t16;
		t16.right = t17;
		t17.right = t18;
		return t1;
	}
	
	/*
	 * This tree will be converted to a sum tree.
	 */
	public static TreeNode getSumTree(){
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		//Tree t7 = new Tree(7);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
//		t3.right = t7;
		return t1;
	}
	
	/*
	 * This is a sum tree. This tree will be checked if it is a sum tree
	 */
	public static TreeNode getSumTree2(){
		TreeNode t1 = new TreeNode(26);
		TreeNode t2 = new TreeNode(10);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(6);
		TreeNode t7 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.right = t7;
		return t1;
	}
	
	/*
	 * This is a sum tree. This tree will be checked if it is a sum tree
	 */
	public static TreeNode getSumTree3(){
		TreeNode t1 = new TreeNode(34);
		TreeNode t2 = new TreeNode(12);
		TreeNode t3 = new TreeNode(5);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(3);
		TreeNode t6 = new TreeNode(2);
		TreeNode t7 = new TreeNode(3);
		TreeNode t8 = new TreeNode(1);
		TreeNode t9 = new TreeNode(2);
		TreeNode t10 = new TreeNode(1);
		TreeNode t11 = new TreeNode(1);
		TreeNode t12 = new TreeNode(1);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t4.left = t8;
		t4.right = t9;
		t5.left = t10;
		t5.right = t11;
		t11.right = t12;
		t3.left = t6;
		t3.right = t7;
		return t1;
	}
	
	public static TreeNode getTree2(){
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		t7.left = t4; t7.right = t8;
		t4.left = t3; t4.right = t5;
		t3.left = t2;
		t2.right = t1;
		t5.right = t6;
		return t7;
	}

	public static TreeNode getTree3(){
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2; t1.right = t5;
		t2.left = t3; t2.right = t4;
		return t1;
	}

	public static TreeNode getTree4(){
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(-1);
		TreeNode t4 = new TreeNode(-1);
		TreeNode t5 = new TreeNode(3);
		t1.left = t2; t1.right = t5;
		t2.left = t3; t2.right = t4;
		return t1;
	}
	
}