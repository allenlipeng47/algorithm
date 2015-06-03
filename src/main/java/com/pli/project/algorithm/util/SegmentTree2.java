package com.pli.project.algorithm.util;

public class SegmentTree2 {

	SegIntervalNode[] segNodes;

	public SegmentTree2(int left, int right) {
		int diff = right - left + 1; // diff is actually number of leaf.
		// Calculate the size of array according to diff
		int index = (int) Math.ceil(Math.log(diff) / Math.log(2));
		int space = (int) Math.pow(2, index) * 2;
		segNodes = new SegIntervalNode[space];
		constructSeg(1, left, right);
	}

	/*
	 * Construct a SegNode, with range [left, right]. Put it to segNodes[index].
	 */
	private void constructSeg(int index, int left, int right) {
		SegIntervalNode node = new SegIntervalNode(index, left, right);
		segNodes[index] = node;
		if (left < right) {
			int mid = (left + right) >> 1;
			constructSeg(index * 2, left, mid);
			constructSeg(index * 2 + 1, mid + 1, right);
		}
	}

	/*
	 * Add a segment [left, right] to segment tree
	 */
	public void add(int left, int right) {
		if (left > right) {
			return;
		}
		addUtil(1, left, right);
	}

	private void addUtil(int index, int left, int right) {
		SegIntervalNode node = segNodes[index];
		if (left <= node.left && right >= node.right) {
			node.cover++;
			return;
		}
		int mid = (node.left + node.right) >> 1;
		if (left <= mid) {
			addUtil(index * 2, left, right);
		}
		if (right > mid) {
			addUtil(index * 2 + 1, left, right);
		}
	}

	/*
	 * Delete a segment [left, right] from segment tree
	 */
	public void delete(int left, int right) {
		if (left > right) {
			return;
		}
		deleteUtil(1, left, right);
	}

	private void deleteUtil(int index, int left, int right) {
		SegIntervalNode node = segNodes[index];
		if (left <= node.left && right >= node.right) {
			node.cover--;
			return;
		}
		int mid = (node.left + node.right) >> 1;
		if (left <= mid) {
			deleteUtil(index * 2, left, right);
		}
		if (right > mid) {
			deleteUtil(index * 2 + 1, left, right);
		}
	}

	/*
	 * Print all covered segments
	 */
	public void print() {
		printUtil(1, segNodes[1].left, segNodes[1].right);
	}

	public void printUtil(int index, int left, int right) {
		SegIntervalNode node = segNodes[index];
		if (node.cover != 0) {
			System.out.println("[" + left + ", " + right + "]\t" + node.cover);
			return;
		}
		if (left >= right) {
			return;
		}
		int mid = (node.left + node.right) >> 1;
		if (left <= mid) {
			printUtil(index * 2, left, mid);
		}
		if (right > mid) {
			printUtil(index * 2 + 1, mid + 1, right);
		}
	}

	public static void main(String[] args) {
		SegmentTree2 tree = new SegmentTree2(0, 7);
		tree.add(3, 6);
		tree.print();
		System.out.println();
	}
}
