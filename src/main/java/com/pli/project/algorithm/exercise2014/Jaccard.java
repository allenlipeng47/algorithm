package com.pli.project.algorithm.exercise2014;

import java.util.Arrays;
import java.util.HashSet;

public class Jaccard {

	public static void main(String[] args) {
		char[] str = {'a', 'f', 'g', 'e', 'a', 'c', 'a', 'd', 'f', 'b', 'q'};
		int pos = 5;
		calJacDistance(str, pos);
		
		char[] a = {'a', 'b', 'c', 'd','e','g'};
		char[] b = {'a', 'd', 'f', 'f', 'g'};
		calJacDistance2(a, b);
	}
	
	/*
	 * Time O(m+n), space O(m+n)
	 */
	public static void calJacDistance2(char[] a, char[] b){
		if(a==null||b==null||a.length<1||b.length<1){
			return;	//lenght of b[] is zero.
		}
		HashSet<Character> hs1 = new HashSet<Character>();
		HashSet<Character> hs2 = new HashSet<Character>();
		for(int i=0;i<a.length;i++){
			hs1.add(a[i]);
		}
		for(int i=0;i<b.length;i++){
			hs2.add(b[i]);
		}
		//put elements from hs2 to hs1. During this process, record how many duplication it is.
		int dup_num = 0;
		for(char ch:hs2){
			if(hs1.contains(ch)){
				dup_num++;
			}
			else{
				hs1.add(ch);
			}
		}
		int union_num = hs1.size();
		System.out.println((double)dup_num / (double)union_num);
	}

	/*
	 * The idea of this solution is to sort and find the duplicaitons.
	 * str[0,...,pos] is the a[], str[pos+1,...,len-1] is b[]
	 * time O[(m+n)log(m+n)], space O(1).
	 * time mostly is costed by sorting.
	 */
	public static void calJacDistance(char[] str, int pos){
		if(pos==str.length-1||pos<0){
			return;	//lenght of b[] is zero.
		}
		Arrays.sort(str, 0, pos+1);
		Arrays.sort(str, pos+1, str.length);
		//below 2 for loop is to deduplicate a[] and b[] separately
		int dup_num = 0;	//to record how many duplication are there in str.
		for(int i=1;i<=pos;i++){
			if(str[i]==str[i-1-dup_num]){
				dup_num++;
			}
			else{
				str[i-dup_num] = str[i];
			}
		}
		str[pos+1-dup_num] = str[pos+1];
		for(int i=pos+2;i<str.length;i++){
			if(str[i]==str[i-1-dup_num]){
				dup_num++;
			}
			else{
				str[i-dup_num] = str[i];
			}
		}
		Arrays.sort(str, 0, str.length -dup_num);	//sort the new array
		//duplication number in str[0,...,len-dup_num-1] will be the intersection number
		//str.len-dup_num-dup_num2 will be the union number
		int dup_num2 = 0;
		for(int i=1;i<str.length-dup_num;i++){
			if(str[i]==str[i-1-dup_num2]){
				dup_num2++;
			}
			else{
				str[i-dup_num2] = str[i];
			}
		}
		int union_num = str.length - dup_num - dup_num2;
		System.out.println((double)dup_num2 / (double)union_num);
	}
	
}
