package com.pli.project.algorithm.exercise2014;

public class FindWeightedMedianInMatrix {
	
	
	public static void main(String[] args){
		int[][] array = {
				{0, 4, 0, 0},
				{0, 0, 0, 3},
				{1, 0, 0, 0},
				{1, 0, 5, 0},
				{5, 0, 0, 0},
		};
		int[][] element = {
				{0, 1, 4},
				{1, 3, 3},
				{2, 0, 1},
				{3, 0, 1},
				{3, 2, 5},
				{4, 0, 5},
		};
		int[][] vote = new int[array.length][array[0].length];
		for(int i=0; i<vote.length; i++){
			for(int j=0;j<vote[0].length;j++){
				for(int m=0;m<element.length;m++){
					vote[i][j] = vote[i][j] + Math.abs(element[m][0]-i)*element[m][2] + Math.abs(element[m][1]-j)*element[m][2];
				}
			}
		}
		
		for(int i=0;i<vote.length;i++){
			for(int j=0;j<vote[0].length;j++){
				System.out.print(vote[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
}