package com.pli.project.algorithm.exercise2014;

import java.util.Arrays;

public class SortAccordingToAnArray {

	public static void main(String[] args) {
		int[] arr = { 5, 12, 14, 27, 3, 2, 13, 17, 7, 21 };
		int[] index = { 3, 6, 2, 9, 7, 1, 4, 8, 5, 10 };
		System.out.println("Values: " + Arrays.toString(arr));
		System.out.println(" Index: " + Arrays.toString(index));
		putRightPosition(arr, index);
		System.out.println("Values: " + Arrays.toString(arr));
	}
	
	public static void putRightPosition(int[] num, int[] seq){
		for(int i=0;i<num.length;i++){
			if(seq[i]<0){
				continue;
			}
			int curr_value = num[i];
			int next_pos = seq[i]-1;
			seq[i] = -seq[i];
			while(true){
				int tmp = num[next_pos];
				num[next_pos] = curr_value;
				curr_value = tmp;
				tmp = next_pos;
				next_pos = seq[next_pos]-1;
				if(next_pos<0){
					break;
				}
				seq[tmp] = -seq[tmp];
			}//while
		}//for
	}
}