package com.pli.project.algorithm.util;

public class SegIntervalNode {
	int index;
	int left;
	int right;
	int cover;

	public SegIntervalNode() {
	}

	public SegIntervalNode(int index, int left, int right) {
		this.index = index;
		this.left = left;
		this.right = right;
	}
}
