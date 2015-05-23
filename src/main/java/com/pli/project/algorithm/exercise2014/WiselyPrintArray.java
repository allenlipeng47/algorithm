package com.pli.project.algorithm.exercise2014;

public class WiselyPrintArray {
	
	public static void main(String[] args) {
		int[][] array = {
				{2,5,6,10,5},
				{4,8,9,12,3},
				{1,2,3,4,5}
				};
		int[][] array2 = {
				{2,5},
				{4,8},
				{1,2},
				{3,7},
				{4,8},
				{5,9},
				};
		printWiseMatrix(array2);
	}
	
	//顺时针方向打印n*m矩阵
	public static void printWiseMatrix(int[][] array){
		if(array==null)
			return;
		int row_start = 0;
		int row_end = array.length-1;
		int col_start = 0;
		int col_end = array[0].length-1;
		while(row_start<row_end||col_start<col_end){
			for(int i=col_start;i<=col_end&&row_start<=row_end;i++){
				System.out.print(array[row_start][i]+" ");
			}
			row_start++;
			for(int i=row_start;i<=row_end&&col_start<=col_end;i++){
				System.out.print(array[i][col_end]+" ");
			}
			col_end--;
			for(int i=col_end;i>=col_start&&row_start<=row_end;i--){
				System.out.print(array[row_end][i]+" ");
			}
			row_end--;
			for(int i=row_end;i>=row_start&&col_start<=col_end;i--){
				System.out.print(array[i][col_start]+" ");
			}
			col_start++;
		}
	}

}










