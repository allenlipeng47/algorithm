package com.pli.project.algorithm.util;



public class Tree{
	public Tree(int value){
		this.value = value;
	}
	public Tree(String value){
		this.valueString = value;
	}
	public Tree left;
	public Tree right;
	public int value;
	public String valueString;
	public static Tree getTree(){
		Tree t18 = new Tree(18);
		Tree t17 = new Tree(17);
		Tree t16 = new Tree(16);
		Tree t15 = new Tree(15);
		Tree t14 = new Tree(14);
		Tree t13 = new Tree(13);
		Tree t12 = new Tree(12);
		Tree t11 = new Tree(11);
		Tree t10 = new Tree(10);
		Tree t9 = new Tree(9);
		Tree t8 = new Tree(8);
		Tree t7 = new Tree(7);
		Tree t6 = new Tree(6);
		Tree t5 = new Tree(5);
		Tree t4 = new Tree(4);
		Tree t3 = new Tree(3);
		Tree t2 = new Tree(2);
		Tree t1 = new Tree(1);
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
	public static Tree getSumTree(){
		Tree t1 = new Tree(1);
		Tree t2 = new Tree(2);
		Tree t3 = new Tree(3);
		Tree t4 = new Tree(4);
		Tree t5 = new Tree(5);
		Tree t6 = new Tree(6);
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
	public static Tree getSumTree2(){
		Tree t1 = new Tree(26);
		Tree t2 = new Tree(10);
		Tree t3 = new Tree(3);
		Tree t4 = new Tree(4);
		Tree t5 = new Tree(6);
		Tree t7 = new Tree(3);
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
	public static Tree getSumTree3(){
		Tree t1 = new Tree(34);
		Tree t2 = new Tree(12);
		Tree t3 = new Tree(5);
		Tree t4 = new Tree(3);
		Tree t5 = new Tree(3);
		Tree t6 = new Tree(2);
		Tree t7 = new Tree(3);
		Tree t8 = new Tree(1);
		Tree t9 = new Tree(2);
		Tree t10 = new Tree(1);
		Tree t11 = new Tree(1);
		Tree t12 = new Tree(1);
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
	
	public static Tree getTree2(){
		Tree t1 = new Tree(1);
		Tree t2 = new Tree(2);
		Tree t3 = new Tree(3);
		Tree t4 = new Tree(4);
		Tree t5 = new Tree(5);
		Tree t6 = new Tree(6);
		Tree t7 = new Tree(7);
		Tree t8 = new Tree(8);
		t7.left = t4; t7.right = t8;
		t4.left = t3; t4.right = t5;
		t3.left = t2;
		t2.right = t1;
		t5.right = t6;
		return t7;
	}
	
}