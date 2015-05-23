package com.pli.project.algorithm.exercise2014;

public class MedianIn2SortedArray {
	
	public static void main(String[] args) {
		int[] a = {1,3,5,9,10};
		int[] b = {2,4,6,8};
		int median = findMedian(a,b);
		System.out.println(median);
	}
	
	public static int findMedian(int[] a, int[] b){
		int k = (a.length + b.length)/2;
		return findK(a, b, k, 0, a.length-1, 0, b.length-1);
		
	}
	
	public static int findK(int[] a, int[] b, int k, int a_start, int a_end, int b_start, int b_end){
		if(a_start>a_end){
			return b[b_start+k-1];
		}
		if(b_start>b_end){
			return a[a_start+k-1];
		}
		int a_mid = a_start+(a_end-a_start)/2;
		int b_mid = b_start+(b_end-b_start)/2;
		int half_len = a_mid-a_start+b_mid-b_start+2;
		if(a[a_mid]>b[b_mid]){
			if(k<half_len){
				//cut off the high part of large array, which is high of a[]
				return findK(a, b, k, a_start, a_mid-1, b_start, b_end);
			}
			else{
				//cut off the low part of small array, which is low of b[]
				return findK(a, b, k-(b_mid-b_start+1),a_start, a_end, b_mid+1, b_end);
			}
		}
		else{
			if(k<half_len){
				//cut off the high part of large array, which is high of b[]
				return findK(a, b, k, a_start, a_end, b_start, b_mid-1);
			}
			else{
				//cut off the low part of small array, which is low of a[]
				return findK(a, b, k-(a_mid-a_start+1), a_mid+1, a_end, b_start, b_end);
			}
		}
	}
}
