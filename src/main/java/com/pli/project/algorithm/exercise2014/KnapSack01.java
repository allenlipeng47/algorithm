package com.pli.project.algorithm.exercise2014;

public class KnapSack01 {
	
	public static void main(String[] args) {
		int[] w = {0, 2, 2, 6, 5, 4};
		int[] v = {0, 6, 3, 5, 4, 6};
		System.out.println(knapSack(w, v, 10));
	}
	
	public static int knapSack(int[] w, int[] v, int weight){
		int[][] f = new int[w.length][weight];
		for(int i = 1; i < w.length; i++ ){
			for(int j = 1; j < weight; j++){
				f[i][j] = Math.max(f[i-1][j], v[i] + f[i-1][(j - w[i]) < 0 ? 0 : (j - w[i])]);
			}
		}
		return f[w.length - 1][weight - 1];
	}

}