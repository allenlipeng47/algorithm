package com.pli.project.algorithm.util;
import java.util.Stack;


//a queue(FIFO) can track min and max of all elements in amortized O(1) time
public class MQueue {
	MStack s_new = new MStack(), s_old = new MStack();

	public void enqueue(int i) {
		s_new.push(i);
	}

	public int dequeue() {
		if (s_old.isEmpty()) {
			while (!s_new.isEmpty()) {
				s_old.push(s_new.pop());
			}
		}
		return s_old.pop();
	}

	public boolean isEmpty() {
		return s_new.isEmpty() && s_old.isEmpty();
	}

	public int min() {
		return Math.min(s_new.min(), s_old.min());
	}

	public int max() {
		return Math.max(s_new.max(), s_old.max());
	}
}

// a stack node which contains min and max of all underlying elements
class MNode {
	Integer i, min, max;

	MNode(int i, int max, int min) {
		this.i = i;
		this.max = max;
		this.min = min;
	}
}

// a stack(LIFO) can track min and max of all elements in amortized O(1) time
class MStack {
	Stack<MNode> s = new Stack<MNode>();

	public boolean isEmpty() {
		return s.isEmpty();
	}

	public int min() {
		if (s.isEmpty())
			return Integer.MAX_VALUE;
		return s.peek().min;
	}

	public int max() {
		if (s.isEmpty())
			return Integer.MIN_VALUE;
		return s.peek().max;
	}

	public void push(int i) {
		int max = Math.max(i, max());
		int min = Math.min(i, min());
		s.push(new MNode(i, max, min));
	}

	public int pop() {
		System.out.println(s.peek().i);
		return s.pop().i;
	}
}

