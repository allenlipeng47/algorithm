package com.pli.project.algorithm.exercise2014;

public class FindKthInSortedArray {
	
	public static void main(String[] args) {
		int[][] array = {
				{2,5,6,10},
				{4,8,9,12},
				{7,15,20,22}
		};
		findKthInSortedArray(array, 6);
		
	}
	
	/*
	 * 矩阵array是从左到右，从上到下的有序矩阵，找出第k小的元素
	 * http://www.careercup.com/question?id=14880812
	 */
	public static void findKthInSortedArray(int[][] array, int k){
		int min = array[0][0];
		int[] minOfRows = new int[array.length];
		minOfRows[0] = 1;
		int r = 0;
		for(int i=0;i<k;i++){
			min = Integer.MAX_VALUE;
			for(int j=0;j<array.length;j++){
				if(minOfRows[j]<array[0].length){
					if(array[j][minOfRows[j]]<min){
						min = array[j][minOfRows[j]];
						r = j;
					}
				}
			}
			minOfRows[r]++;
		}
		System.out.println();
	}
	

}
