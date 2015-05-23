package com.pli.project.algorithm.exercise2014;

public class AddLinkedList {
	
	public static void main(String[] args) {
		LinkList l = new LinkList(1);
		l.addToEnd(2);
		l.addToEnd(3);
		System.out.println();
	}
	
	public static void addToEnd(LinkList list, int value){
		if(list.next==null){
			list.next = new LinkList(value);
			return;
		}
		addToEnd(list.next, value);
	}

}

class LinkList{
	int value;
	public LinkList next;
	public LinkList(int value){
		this.value = value;
	}
	
	public void addToEnd(int value){
		if(this.next==null){
			this.next = new LinkList(value);
			return;
		}
		this.next.addToEnd(value);
	}
	
}