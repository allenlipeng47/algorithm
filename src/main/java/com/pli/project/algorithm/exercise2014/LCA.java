package com.pli.project.algorithm.exercise2014;

import java.util.ArrayList;
import java.util.Iterator;
import com.pli.project.algorithm.exercise2014.util.MyInteger;
import com.pli.project.algorithm.exercise2014.util.Tree;


public class LCA {
	
	public static void main(String[] args) {
		Tree tree = Tree.getTree();
		ArrayList<Integer> path = findNodesPath(tree, 9, 18);
		printPath(path);
	}
	
	/*
	 * Find the LCA of node1 and node2
	 */
	public static Tree findLca(Tree tree, MyInteger lcaNum, int node1, int node2){
		if(tree==null){
			return null;
		}
		MyInteger lLca = new MyInteger(0);
		Tree ltree = findLca(tree.left, lLca, node1, node2);
		if(lLca.i==2){
			lcaNum.i=2;
			return ltree;
		}
		MyInteger rLca = new MyInteger(0);
		Tree rtree = findLca(tree.right, rLca, node1, node2);
		if(rLca.i==2){
			lcaNum.i=2;
			return rtree;
		}
		int selfLca = 0;
		if(node1==tree.value||node2==tree.value){
			selfLca = 1;
		}
		lcaNum.i = lLca.i + rLca.i + selfLca;
		return tree;
	}

	/*
	 * Find the path of node under root.
	 */
	public static boolean findPath(Tree root, int node, ArrayList<Integer> path){
		if(root==null){
			return false;
		}
		boolean lHas = findPath(root.left, node, path);
		if(lHas){
			path.add(root.value);
			return true;
		}
		boolean rHas = findPath(root.right, node, path);
		if(rHas){
			path.add(root.value);
			return true;
		}
		if(root.value==node){
			path.add(root.value);
			return true;
		}
		return false;
	}
	
	/*
	 * Find the path of node1(or node2) under root.
	 */
	public static boolean findPath(Tree root, int node1, int node2, ArrayList<Integer> path){
		if(root==null){
			return false;
		}
		if(findPath(root.left, node1, node2, path)){
			path.add(root.value);
			return true;
		}
		if(findPath(root.right, node1, node2, path)){
			path.add(root.value);
			return true;
		}
		if(root.value==node1||root.value==node2){
			path.add(root.value);
			return true;
		}
		return false;
	}
	
	/*
	 * Find the path between node1 and node2
	 */
	public static ArrayList<Integer> findNodesPath(Tree tree, int node1, int node2){
		MyInteger lcaNum = new MyInteger(0);
		Tree lca = findLca(tree, lcaNum, node1, node2);
		if(lcaNum.i<2){
			return null;
		}
		ArrayList<Integer> path1 = new ArrayList<Integer>();
		ArrayList<Integer> path2 = new ArrayList<Integer>();
		findPath(lca.left, node1, node2, path1);
		findPath(lca.right, node1, node2, path2);
		path1.add(lca.value);
		while(!path2.isEmpty()){
			path1.add(path2.remove(path2.size()-1));
		}
		return path1;
	}
	
	public static void printPath(ArrayList<Integer> path){
		if(path==null){
			return;
		}
		Iterator<Integer> itr = path.iterator();
		while(itr.hasNext()){
			System.out.print(itr.next()+" ");
		}
		System.out.println();
	}
	
}
