package com.pli.project.algorithm.exercise2014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LowestCostToSort {

	public static void main(String[] args) {
		int[] num = { 1, 5, 2, 2 };
		System.out.println("input array:\t" + Arrays.toString(num));
		int cost = getLowestCostToSort(num);
		System.out.println("total cost:\t" + cost);
	}

	public static int getLowestCostToSort(int[] num) {
		Set<Integer> uniqueSet = new TreeSet<Integer>();
		for (int i : num) {
			uniqueSet.add(i);
		}
		Integer[] uniqueNum = (Integer[]) uniqueSet
				.toArray(new Integer[uniqueSet.size()]);
		CostTrack[][] dp = new CostTrack[num.length][uniqueNum.length];
		// initial dp[0][]
		for (int i = 0; i < uniqueNum.length; i++) {
			if (num[0] >= uniqueNum[i]) {
				dp[0][i] = new CostTrack(num[0] - uniqueNum[i], -1);
				continue;
			}
			dp[0][i] = new CostTrack(0, -1);
		}
		for (int i = 1; i < num.length; i++) {
			for (int j = 0; j < uniqueNum.length; j++) {
				// Considering adding num[i] to the sorted array,
				int diff = (num[i] >= uniqueNum[j]) ? (num[i] - uniqueNum[j])
						: num[i];
				dp[i][j] = new CostTrack(Integer.MAX_VALUE, -1);
				for (int k = 0; k <= j; k++) {
					if (dp[i - 1][k].cost + diff < dp[i][j].cost) {
						dp[i][j].cost = dp[i - 1][k].cost + diff;
						dp[i][j].from = k;
					}
				}
			}
		}
		// print result
		int result = -1, result_cost = Integer.MAX_VALUE;
		for (int i = 0; i < uniqueNum.length; i++) {
			if (dp[num.length - 1][i].cost < result_cost) {
				result_cost = dp[num.length - 1][i].cost;
				result = i;
			}
		}
		List<Integer> result_list = new ArrayList<Integer>();
		for (int i = num.length - 1; i >= 0; i--) {
			if (num[i] >= uniqueNum[result]) {
				result_list.add(0, uniqueNum[result]);
				result = dp[i][result].from;
			}
		}
		System.out.println("sorted array:\t" + result_list.toString());
		return result_cost;
	}

	static class CostTrack {
		int cost;
		int from;

		public CostTrack(int cost, int from) {
			this.cost = cost;
			this.from = from;
		}
	}

}
