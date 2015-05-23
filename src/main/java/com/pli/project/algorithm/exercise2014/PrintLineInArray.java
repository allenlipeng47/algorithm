package com.pli.project.algorithm.exercise2014;

import java.awt.Point;


public class PrintLineInArray {
	
	
	public static void printLineInArray(boolean[][] array, Point p1, Point p2){
		if(Math.abs(p1.x-p2.x)<Math.abs(p1.y-p2.y)){
			/*
			 * ........xx.
			 * .....xxx...
			 * ..xxx......
			 */
			Point p_start = p1.y<=p2.y?p1:p2;
			Point p_end = p1.y>p2.y?p2:p1;
			int length = Math.abs(p1.y - p2.y) + 1;
			int width = Math.abs(p1.x - p2.x) + 1;
			int section = length / width;
//			int last_sec = 
			if(p_start.x<=p_end.x){
				//from left to right
				for(int i=p_start.y;i<p_end.y;i++){
					for(int j=0;i<section;i++){
						array[i][(i-p_start.y)*section+j] = true;
					}
				}//for
				
			}//if
			else{
				//from right to left
			}
			
		}
		else{
			//Vertically print
			
		}
		
	}

}







