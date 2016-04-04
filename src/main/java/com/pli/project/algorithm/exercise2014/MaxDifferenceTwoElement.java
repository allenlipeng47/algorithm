package com.pli.project.algorithm.exercise2014;

/*
 * http://www.geeksforgeeks.org/amazon-interview-experience-set-149-campus-internship/
 * Q2. Given an array arr[] of integers, find out the maximum difference between any 
 * two elements such that larger element appears after the smaller number in arr[]. 
 * Print the indices of the two elements also.
 * Example: If array is [2, 3, 10, 6, 4, 8, 1] then returned val should be 8 (difference between 10 and 2).
 * If array is [ 7, 9, 5, 6, 3, 2 ] then returned val should be 2 (difference between 7 and 9).
 */
public class MaxDifferenceTwoElement {
	
	public static void main(String[] args) {
		int[] array = {7, 9, 5, 6, 3, 2};
		findMaxDifference(array);
	}
	
	
	public static void findMaxDifference(int[] array){
		if(array==null){
			return;
		}
		int min_pos = 0;	//position of min val
		int max_pos = 0;	//position of max val
		int max_gap = Integer.MIN_VALUE;
		for(int i=1;i<array.length;i++){
			if(array[i]-array[min_pos]>max_gap){
				max_pos = i;
				max_gap = array[i] - array[min_pos];
			}
			else if(array[i]<min_pos){
				min_pos = i;
			}
		}
		System.out.println(max_gap);
	}

}
