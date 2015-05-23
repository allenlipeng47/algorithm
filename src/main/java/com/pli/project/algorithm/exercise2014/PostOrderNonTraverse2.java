package com.pli.project.algorithm.exercise2014;

import java.util.ArrayList;


public class PostOrderNonTraverse2 {
	
	
	public static void main(String[] args){
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
		PostTraverse(t1);
		
	}
	
	public static void PostTraverse(Tree tree){
		ArrayList<Tree> s = new ArrayList<Tree>();
		s.add(tree);
		Tree prev = null;
		Tree curr = null;
		Tree next = null;
		while(!s.isEmpty()){
			curr = s.get(s.size()-1);
			if(prev==null||prev.left==curr||prev.right==curr){
				//新进来的
				if(curr.left==null&&curr.right==null){	//是叶子
					System.out.println(curr.value);
					s.remove(s.size()-1);
				}
				else{
					if(curr.left!=null){
						s.add(curr.left);
					}
					else{
						s.add(curr.right);
					}
				}
			}
			else if(curr.left == prev){	//从左子树返回的
				if(curr.right!=null){
					s.add(curr.right);
				}
				else{
					System.out.println(curr.value);
					s.remove(s.size()-1);
				}
			}
			else{	//从右子树返回
				System.out.println(curr.value);
				s.remove(s.size()-1);
			}
			prev = curr;
		}
		
		
	}
	

}
