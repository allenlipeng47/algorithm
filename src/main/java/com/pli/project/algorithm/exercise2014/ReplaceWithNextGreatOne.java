package com.pli.project.algorithm.exercise2014;

import java.util.Arrays;


/*
 * http://www.geeksforgeeks.org/replace-every-element-with-the-greatest-on-right-side/
 * Given an array of integers, replace every element with the next greatest 
 * element (greatest element on the right side) in the array. Since there is 
 * no element next to the last element, replace it with -1. For example, if 
 * the array is {16, 17, 4, 3, 5, 2}, then it should be modified to {17, 5, 5, 5, 2, -1}.
 */
public class ReplaceWithNextGreatOne {
	
	public static void main(String[] args) {
		int[] array = {16, 17, 4, 3, 5, 2};
		replaceWithNextGreatOne(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void replaceWithNextGreatOne(int[] array){
		int curr_max = -1;
		for(int i=array.length-1;i>=0;i--){
			int tmp = array[i];
			array[i] = curr_max;
			curr_max = tmp>curr_max?tmp:curr_max;
		}
	}

}
