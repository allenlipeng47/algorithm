package com.pli.project.algorithm.exercise2014;

import java.util.Arrays;


public class AlternateNumber {
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,-1,-3,-4,5,-2};
		alternate2(a);
		System.out.println(Arrays.toString(a));
	}
	
	public static void alternate(int[] a) {
		int p = 1;
		int n = 1;
		boolean findPositive = false;
		if (a[0] < 0) {
			findPositive = true;
		}

		int t;
		for (int i = 1; i < a.length && p < a.length && n < a.length; i++) {
			if (findPositive) {
				while (p < a.length && a[p] < 0) {
					p++;
				}
				t = p++;
			} else {
				while (n < a.length && a[n] >= 0) {
					n++;
				}
				t = n++;
			}
			if (t<a.length) {
				int tmp = a[t];	a[t] = a[i]; a[i] = tmp;
//				swap(a, t, i);
				findPositive = !findPositive;	
			}
		}
	}
	

	public static void alternate2(int[] a){
		int next_positive = 0;
		int next_negative = 0;
		for(int i=0;i<a.length-1&& next_positive<a.length&&next_negative<a.length;i++){
			if((i%2==0&&a[i]<0)||(i%2==1&&a[i]>0)){
				continue;
			}
			if(i%2==0){
				next_negative = i+1;
				//find the next negative number
				while(next_negative<a.length&&a[next_negative]>0){
					next_negative++;
				}
				int tmp = a[i]; a[i] = a[next_negative]; a[next_negative] = tmp;
				continue;
			}
			if(i%2==1){
				next_positive = i+1;
				//find the next positive number
				while(next_negative<a.length&&a[next_negative]<0){
					next_positive++;
				}
				int tmp = a[i]; a[i] = a[next_positive]; a[next_positive] = tmp;
				continue;
			}
		}
	}
}
