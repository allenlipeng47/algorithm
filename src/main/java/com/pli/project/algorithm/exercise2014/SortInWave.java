package com.pli.project.algorithm.exercise2014;

import java.util.Arrays;


public class SortInWave {
	
	
	public static void main(String[] args) {
		int[] array = {2,1,3,4,5};
		sortInWave(array);
		System.out.println(Arrays.toString(array));
		
	}
	
	/*
	 * For each even i, make sure that arr[i] is larger than arr[i-1] and arr[i+1]
	 */
	public static void sortInWave(int[] array){
		if(array==null||array.length<=1){
			return;
		}
		for(int i=0;i<array.length;i+=2){
			if(i>0&&array[i-1]>array[i]){
				swap(array, i-1, i);
			}
			if(i<array.length-1&&array[i]<array[i+1]){
				swap(array, i, i+1);
			}
		}
	}
	
	public static void swap(int[] array, int a, int b){
		int tmp = array[a];	array[a] = array[b]; array[b] = tmp;
	}
	
}
