package com.pli.project.algorithm.exercise2014;

/*
 * http://www.geeksforgeeks.org/amazon-interview-experience-set-152/
 * 1. Given an array of 0s and 1s, find the position of 0 to be replaced 
 * with 1 to get longest continuous sequence of 1s.
 * Eg: Array- 1,1,0,0,1,0,1,1,1,0,1,1,1
 * Output - index 9
 * Assuming array index starts from 0. 
 */
public class FindZero {
	
	public static void main(String[] args) {
		int[] array = {0,0,0,0,1,0,1,0};
		findZero(array);
	}
	
	public static void findZero(int[] array){
		int zero1 = -1;
		int zero2 = 0;
		int zero_max = 0;	//用于记录最大的0的位置
		int length_max = 0;	//用于记录最长的长度
		int i;
		for(i=0;i<array.length;i++){
			if(array[i]==0){
				zero2 = i;
				break;
			}
		}
		i++;
		if(i>=array.length){
			return;
		}
		while(i<array.length){
			if(array[i]==1){
				i++;
				continue;
			}
			if(i-zero1-1>length_max){
				zero_max = zero2;
				length_max = i-zero1-1;
			}
			zero1 = zero2;
			zero2 = i;
			i++;
		}
		//check the last one
		if(array[i-1]==1){
			if(i-zero1-1>length_max){
				zero_max = zero2;
				length_max = i-zero1-1;
			}
		}
		System.out.println("zero pos:"+zero_max);
		System.out.println("max length:"+length_max);
	}

}
