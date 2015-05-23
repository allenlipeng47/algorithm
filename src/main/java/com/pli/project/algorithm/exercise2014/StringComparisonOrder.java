package com.pli.project.algorithm.exercise2014;

/*
 * Output top N positive integer in string comparison order. 
 * For example, let's say N=1000, then you need to output in string comparison order as below: 
 * 1, 10, 100, 1000, 101, 102, ... 109, 11, 110, ...
 * 
 * After run this code, you can find the sequence is actually a digit recursion.
 */
public class StringComparisonOrder {
	
	
	public static void main(String[] args) {
		for(int i=1;i<10;i++){
			printRec(String.valueOf(i),1000);
		}
		
	}
	
	public static void printRec(String str, int n){
		int value = Integer.valueOf(str);
		if(value>n)
			return;
		System.out.println(value);
		for(int i=0;i<10;i++){
			printRec(str+i, n);
		}
	}
	
	
}
