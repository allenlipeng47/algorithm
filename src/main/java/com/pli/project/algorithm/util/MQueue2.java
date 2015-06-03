package com.pli.project.algorithm.util;

import java.util.LinkedList;

public class MQueue2 {
	
	private LinkedList<Integer> q = new LinkedList<Integer>();
	private LinkedList<Integer> maxq = new LinkedList<Integer>();
	private LinkedList<Integer> minq = new LinkedList<Integer>();
	
	public boolean enQueue(int e){
		enMaxq(e);
		enMinq(e);
		q.addLast(e);
		return true;
	}
	
	public int deQueue(){
		if(q.size()<1){
			return Integer.MIN_VALUE;
		}
		int curr = q.removeFirst();
		deMaxq(curr);
		deMinq(curr);
		return curr;
	}
	
	private void enMaxq(int e){
		if(maxq.size()==0){
			maxq.addLast(e);
			return;
		}
		while(!maxq.isEmpty()&&maxq.getLast()<e){
			maxq.removeLast();
		}
		maxq.addLast(e);
	}
	
	private void deMaxq(int e){
		if(maxq.size()<1){
			return;
		}
		int curr = maxq.getFirst();
		if(e==curr){
			maxq.removeFirst();
		}
	}
	
	private void enMinq(int e){
		if(minq.size()==0){
			minq.addLast(e);
			return;
		}
		while(!minq.isEmpty()&&minq.getLast()>e){
			minq.removeLast();
		}
		minq.addLast(e);
	}
	
	private void deMinq(int e){
		if(minq.size()<1){
			return;
		}
		int curr = minq.getFirst();
		if(e==curr){
			minq.removeFirst();
		}
	}
	
	public int min(){
		if(minq.size()<1){
			return Integer.MAX_VALUE;
		}
		return minq.getFirst();
	}
	
	public int max(){
		if(maxq.size()<1){
			return Integer.MIN_VALUE;
		}
		return maxq.getFirst();
	}
	
	public static void main(String[] args) {
		MQueue2 q = new MQueue2();
		q.enMinq(3);
		q.enMinq(3);
		q.enMinq(4);
		q.enMinq(3);
		q.enMinq(1);
		System.out.println();
	}
	
}
