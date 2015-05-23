package com.pli.project.algorithm.exercise2014;

import java.util.Arrays;


/*
 * http://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
 * You are given an array of 0s and 1s in random order. Segregate 0s on left side 
 * and 1s on right side of the array. Traverse array only once.
 * Input array   =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0] 
 * Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1] 
 */
public class SegregateZeroAndOne {
	
	public static void main(String[] args) {
		int[] array = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
		segregateZeroAndOne(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void segregateZeroAndOne(int[] array){
		int left = 0;
		int right = array.length - 1;
		while(left<right){
			while(left<right&&array[left]!=1){
				left++;
			}
			while(left<right&&array[right]!=0){
				right--;
			}
			if(left>=right){
				break;
			}
			array[left] = 0;
			array[right] = 1;
		}
	}

}
