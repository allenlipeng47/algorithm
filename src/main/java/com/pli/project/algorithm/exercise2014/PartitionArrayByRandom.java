package com.pli.project.algorithm.exercise2014;

import java.util.Arrays;


public class PartitionArrayByRandom {
	public static void main(String[] args) {
		int[] array = {9,7,3,6,2,1,4};
		partition(array, 0, array.length-1, 5);
		System.out.println(Arrays.toString(array));
	}
	
	/*
	 * partition array into 2 parts. array[low,...,i] and array[i+1,...,high]
	 * which element in array[low,...,i] is less than val, element in array[i+1,...,high] is larger than val
	 */
	public static void partition(int[] array, int low, int high, int value){
		int startOfHigh = 0;	//indicate the 1st element position of the elements which are larger than val
		for(int i=low;i<high;i++){
			if(array[i]>value){
				continue;
			}
			if(array[i]<value){
				swap(array, i, startOfHigh);
				startOfHigh++;
			}
			else{	//array[i]==val
				swap(array, i, high);
				i--;
			}
		}
		swap(array, startOfHigh, high);
	}
	
	public static void swap(int[] array, int a, int b){
		int tmp = array[a];	array[a] = array[b]; array[b] = tmp;
	}
}
