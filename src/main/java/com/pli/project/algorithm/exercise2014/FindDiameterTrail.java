package com.pli.project.algorithm.exercise2014;

import java.util.ArrayList;
import java.util.Iterator;

public class FindDiameterTrail{
	
	public static void main(String[] args) {
		Tree t = Tree.getTree();
		findDiameterTrail(t);
	}
	
	public static void findDiameterTrail(Tree t){
		DiaData diaData = getDiameterUtil(t);
		ArrayList<Tree> result = diaData.leftTrail;
		while(!result.isEmpty()){
			Tree tree = result.remove(0);
			System.out.println(tree.value);
		}
		System.out.println(diaData.lca.value);
		result = diaData.rightTrail;
		while(!result.isEmpty()){
			Tree tree = result.remove(result.size()-1);
			System.out.println(tree.value);
		}
		
	}
	
	public static DiaData getDiameterUtil(Tree t){
		if(t==null){
			DiaData diameter = new DiaData(0, 0);
			diameter.leafTrail = new ArrayList<Tree>();
			diameter.leftTrail = new ArrayList<Tree>();
			diameter.rightTrail = new ArrayList<Tree>();
			return diameter;
		}
		DiaData left = getDiameterUtil(t.left);
		DiaData right = getDiameterUtil(t.right);
		DiaData diameter = new DiaData();
		//deal with the depth
		if(left.depth>right.depth){
			diameter.depth = left.depth + 1;
			diameter.leafTrail = trailCopy(left.leafTrail);
		}
		else{
			diameter.depth = right.depth + 1;
			diameter.leafTrail = trailCopy(right.leafTrail);
		}
		diameter.leafTrail.add(t);
		//deal with the diameter node.
		if(left.depth+right.depth+1>Math.max(left.diameter, right.diameter)){
			diameter.diameter = left.depth+right.depth+1;
			diameter.leftTrail = left.leafTrail;
			diameter.rightTrail = right.leafTrail;
			diameter.lca = t;
			return diameter;
		}
		if(left.diameter>right.diameter){
			diameter.leftTrail = left.leftTrail;
			diameter.rightTrail = left.rightTrail;
			diameter.diameter = left.diameter;
			diameter.lca = left.lca;
		}
		else{
			diameter.leftTrail = right.leftTrail;
			diameter.rightTrail = right.rightTrail;
			diameter.diameter = right.diameter;
			diameter.lca = right.lca;
		}
//		diameter.leafTrail.add(t);
		return diameter;
	}
	
	public static ArrayList<Tree> trailCopy(ArrayList<Tree> t){
		ArrayList<Tree> result = new ArrayList<Tree>();
		if(t==null||t.isEmpty()){
			return result;
		}
		Iterator<Tree> itr = t.iterator();
		while(itr.hasNext()){
			result.add(itr.next());
		}
		return result;
	}
	
}

class DiaData{
	int depth;
	int diameter;
	ArrayList<Tree> leftTrail;
	ArrayList<Tree> rightTrail;
	Tree lca;
	ArrayList<Tree> leafTrail;
	public DiaData(int depth, int diameter){
		this.depth = depth;
		this.diameter = diameter;
	}
	public DiaData(){}
}

class Tree{
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