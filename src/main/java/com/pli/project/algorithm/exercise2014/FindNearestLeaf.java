package com.pli.project.algorithm.exercise2014;

import java.util.Arrays;
import com.pli.project.algorithm.util.MyBoolean;
import com.pli.project.algorithm.util.MyInteger;
import com.pli.project.algorithm.util.Tree;


public class FindNearestLeaf {
	
	public static void main(String[] args) {
		Tree tree = Tree.getTree();
		findNearestLeaf(tree, 3);
		System.out.println();
	}
	
	
	public static void findNearestLeaf(Tree tree, int value){
		AncestryInfo ancestry = new AncestryInfo();
		//traverse the tree, to find the relative information
		findNearestLeafUtil(tree, value, ancestry, new MyInteger(), new MyInteger(), new MyBoolean());
		int leaf = ancestry.leaf[0];
		int distance = ancestry.ancestry_level[0];
		for(int i=1;i<ancestry.ancestry_level.length;i++){
			if(i-0+ancestry.ancestry_level[i]<distance){
				distance = i-0+ancestry.ancestry_level[i];
				leaf = ancestry.leaf[i];
			}
		}
		distance--;
		System.out.println("Nearest Leaf:" + leaf + "\tDistance:" + distance);
	}
	
	/*
	 * 
	 */
	public static void findNearestLeafUtil(Tree root, int value, AncestryInfo anc, MyInteger depth, MyInteger leaf, MyBoolean found){
		if(root==null){
			return;
		}
		MyInteger l_depth = new MyInteger(Integer.MAX_VALUE);
		MyInteger r_depth = new MyInteger(Integer.MAX_VALUE);
		MyBoolean l_found = new MyBoolean();
		MyBoolean r_found = new MyBoolean();
		MyInteger l_leaf = new MyInteger();
		MyInteger r_leaf = new MyInteger();
		if(root.left!=null){
			findNearestLeafUtil(root.left, value, anc, l_depth, l_leaf, l_found);
		}
		if(root.right!=null){
			findNearestLeafUtil(root.right, value, anc, r_depth, r_leaf, r_found);
		}
		if(root.left==null&&root.right==null){	// current node is a leaf
			depth.i = 1;
			leaf.i = root.value;
		}
		else{	//if current node is not a leaf, get the depth from information of 2 sub tress.
			depth.i = Math.min(l_depth.i, r_depth.i) + 1;
			leaf.i = l_depth.i<r_depth.i?l_leaf.i:r_leaf.i;
		}
		found.bool = l_found.bool||r_found.bool;
		if(found.bool){
			//if the target node is already found, then current node is treated as an ancestry. So store the ancestry information. 
			anc.ancestry_record = Arrays.copyOf(anc.ancestry_record, anc.ancestry_record.length+1);
			anc.ancestry_record[anc.ancestry_record.length-1] = root.value;
			anc.ancestry_level = Arrays.copyOf(anc.ancestry_level, anc.ancestry_level.length+1);
			anc.ancestry_level[anc.ancestry_level.length-1] = depth.i;
			anc.leaf = Arrays.copyOf(anc.leaf, anc.leaf.length+1);
			anc.leaf[anc.leaf.length-1] = leaf.i;
			return;
		}
		if(root.value==value){	//current node is the target, initial the ancestry information
			found.bool = true;
			anc.ancestry_record = new int[]{root.value};
			anc.ancestry_level = new int[]{depth.i};
			anc.leaf = new int[]{leaf.i};
			return;
		}
		return;
	}

}

class AncestryInfo{
	int[] ancestry_record;	//records the ancestry nodes from target node. Target node is also included in position 0;
	int[] ancestry_level;	//records the min deep of ancestry nodes.
	int[] leaf;		//records the leaf which the ancestry nodes reach to the min deep
}