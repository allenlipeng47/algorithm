package com.pli.project.algorithm.exercise2014;

import java.awt.Point;

public class DiagonalPrintMatrix {
	public static void main(String[] args){
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		printMatrix(matrix);
	}
	
	public static void printMatrix(int[][] matrix){
		for(int i=0;i<matrix.length;i++){
			//start from top line
			Point p = new Point(0, i);
			while(p!=null){
				p = printMatrix(matrix, p);
			}
			System.out.println();
		}
		
		for(int i=1;i<matrix.length;i++){
			//start from the right line
			Point p = new Point(i, matrix.length-1);
			while(p!=null){
				p = printMatrix(matrix, p);
			}
			System.out.println();
		}
	}
	
	public static Point printMatrix(int[][] matrix, Point p){
		System.out.print(matrix[p.x][p.y]+" ");
		if(p.x+1>matrix.length-1||p.y-1<0){
			return null;
		}
		return new Point(p.x+1, p.y-1);
	}
}
