package com.pli.project.algorithm.exercise2014;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class test {

	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 1};
		int min = minSortCostDP(nums);
		System.out.println(min);
		
	}
	
	public static int minSortCostDP(int[] nums) {
		Set<Integer> unique = new HashSet<Integer>();
		for (int i : nums)
			unique.add(i);
		Set<Integer> sortedSet = new TreeSet<Integer>(unique);
		Integer[] sorted = (Integer[]) sortedSet.toArray(new Integer[sortedSet.size()]);

		int lenA = nums.length, lenB = sorted.length;
		int[][] table = new int[lenA][lenB];

		// first row
		for (int col = 0; col < lenB; col++)
			table[0][col] = Math.max(0, nums[0] - sorted[col]);

		int nums_row;
		int sorted_col;
		int diff;
		int cost_of_convert;
		for (int row = 1; row < lenA; row++) {
			for (int col = 0; col < lenB; col++) {
				// either deletion or decrement
				nums_row = nums[row];
				sorted_col = sorted[col];
				diff = nums[row] - sorted_col;
				cost_of_convert = diff >=0 ? diff : nums_row;
//				int cost_of_convert = nums[row] >= sorted[col] ? nums[row] - sorted[col] : nums[row];
				table[row][col] = Integer.MAX_VALUE;
				for (int k = 0; k <= col; k++) {
					table[row][col] = Math.min(table[row - 1][k] + cost_of_convert, table[row][col]);
				}
			}
		}
		int minCost = Integer.MAX_VALUE;
		// last row
		for (int col = 0; col < lenB; col++) {
			minCost = Math.min(table[lenA - 1][col], minCost);
		}
		return minCost;
	}

}
