package com.pli.project.algorithm.exercise2014;

import java.util.HashMap;

public class PatriciaTree {
	public static final int STATE_ROOT = 0;
	public static final int STATE_LEAF = 1;
	public static final int STATE_STRINGLEAF = 2;
	public static final int STATE_MIDDLE = 3;
	
	char c;
	HashMap<Character, PatriciaTree> children;
	int state;	//0 is root, 1 is leaf, 2 is leaf with string, 3 is middle
	String leftString;	//if the node is leaf with string, it has a rest word
	PatriciaTree parent;
	
	//store word into this PatriciaTree, word starts from pos 
	public boolean addNode(String word, int pos, PatriciaTree parent){
		if(word==null||pos>=word.length()){
			return false;
		}
		PatriciaTree child;
		if(state==STATE_ROOT||state==STATE_MIDDLE){
			//if it is root, then find if it children have tree with character pos[0]
			child = children.get(word.charAt(pos));
			if(child==null){	//it doesn't has word.charAt[pos], then create tree under it.
				child = new PatriciaTree(word, pos, this);
				children.put(word.charAt(pos), child);
				return true;
			}
			return child.addNode(word, pos+1, this);	//it has char, then create tree under its child.
		}
		if(state==STATE_LEAF){
			//now it is leaf, and there is still chars, then just change it to a STRINGLEAF
			this.state = STATE_STRINGLEAF;
			this.leftString = word.substring(pos, word.length()-1);
			return true;
		}
		if(state==STATE_STRINGLEAF){
			if(word.charAt(pos)!=leftString.charAt(0)){
				//1st char of leftString doesn't match word[pos], so create the tree under it.
				//And create leftString as its subtree.
				child = new PatriciaTree(word, pos, this);
				children.put(word.charAt(pos), child);
				child = new PatriciaTree(leftString, 0, this);
				children.put(leftString.charAt(0), child);
				this.state = STATE_MIDDLE;
				return true;
			}
			//1st char of leftString match word[pos], so break the stringleaf into middle,
			//and create its child with char of the 1st leftString
			this.state = STATE_MIDDLE;
			child = new PatriciaTree(leftString, 0, this);
			children.put(leftString.charAt(0), child);
			this.leftString = "";
			child.addNode(word, pos+1, child);
			return true;
		}
		
		return false;
	}
	
	public boolean findString(String word, int pos){
		if(pos>=word.length()){
			if(this.state==STATE_MIDDLE){
				return false;	//is in the middle, is not counted as found.
			}
			if(this.state==STATE_LEAF){
				return true;	//return true if this is leaf
			}
			return false;
		}
		PatriciaTree child;
		if(this.state==STATE_ROOT||this.state==STATE_MIDDLE){
			child = this.children.get(word.charAt(pos));
			return child==null?false:child.findString(word, pos+1);
		}
		if(this.state==STATE_LEAF){
			return false;	//the word is larger than the leaf string
		}
		if(this.state==STATE_STRINGLEAF){
			String strInWord = word.substring(pos, word.length());
			if(leftString.equals(strInWord)){
				return true;
			}
		}
		return false;
	}
	
	public PatriciaTree(){
		this.children = new HashMap<Character, PatriciaTree>();
	}
	
	public PatriciaTree(String word, int pos, PatriciaTree parent){
		this.c = word.charAt(pos);
		this.parent = parent;
		this.state = STATE_LEAF;
		this.children = new HashMap<Character, PatriciaTree>();
		if(pos<word.length()-1){
			this.state = STATE_STRINGLEAF;
			this.leftString = word.substring(pos+1, word.length());
		}
	}
	
	public static void main(String[] args) {
		PatriciaTree root = new PatriciaTree();
		root.state = STATE_ROOT;
		String[] words = {"zebra", "zero", "dog", "dot", "ducks", "duh", "ducky"};
		for(int i=0;i<words.length;i++){
			root.addNode(words[i], 0, root);
		}
		System.out.println(root.findString("dogg", 0));
	}
}

