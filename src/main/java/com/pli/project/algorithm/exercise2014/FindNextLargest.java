package com.pli.project.algorithm.exercise2014;

import java.util.Arrays;


/*
 * Description:
 * Find next higher number with same digits. 
 * Example 1 : if num = 25468, o/p = 25486 
 * Example 2 : if num = 21765, o/p = 25167 
 * Example 3 : If num = 54321, o/p = 54321 (cause it's not possible to gen a higher num than tiz with given digits ).
 * 
 * Solution:
 * - Get digits of N in positional order 
 * - Find first digit M that is not in ascending order (searching from right to left) 
 * - If all digits are in ascending order from right to left, then return N 
 * - Find the smallest digit P that is to the right of M and is also larger than M 
 * - Swap positions of M and P 
 * - Sort digits after original position of M in ascending order from left to right 
 * - Build and return from digits
 */
public class FindNextLargest {
	public static void main(String[] args) {
		int[] arr = {4,1,2,5,4};
		printResult(arr);
		getNextBiggerNumber(arr);
	}
	
	public static void getNextBiggerNumber(int[] arr){
		if(arr==null||arr.length<=1){
			return;
		}
		int i;
		for(i=arr.length-2;arr[i]>=arr[i+1]&&i>0;i--);	//find the first element arr[i], which arr[i]<arr[i-1]
		if(arr[i]>=arr[i+1]){
			System.out.println("current val is largest.");
			return;
		}
		int j;
		//find the smallest element arr[j] which is larger than arr[i], in the range of arr[i+1,...,length-1]
		for(j=arr.length-1;j>=i+1&&arr[j]<arr[i];j--);
		swap(arr, i, j);
		Arrays.sort(arr, i+1, arr.length);
		printResult(arr);
	}
	
	public static void swap(int[] arr, int i, int j){
		int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
	}
	
	public static void printResult(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
		}
		System.out.println();
	}
	
}