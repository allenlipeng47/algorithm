package com.pli.project.algorithm.exercise2014;

public class FindMedianOfMedian {
	
	/*
	 * Find the kth number in arr[start,...,end]
	 */
	public static int findKthNum(int[] arr, int start, int end, int k){
		if(end - start < 5){
			//Bubble sort arr[start,...,end] for k times, the arr[start] is the median
			int tmpInt = 0;
			for(int count = 0;count<k;count++, start++){
				for(int j=end;j>start;j--){
					if(arr[j-1]>arr[j]){
						tmpInt = arr[j-1]; arr[j-1] = arr[j]; arr[j] = tmpInt;
					}
				}
			}
			start--;
			return start;
		}
		int groupSize = (end - start + 1) / 5;
		int subStart = 0, subEnd = 0, tmpInt = 0;
		for(int i=0;i<groupSize;i++){
			subStart = start + i * 5;
			subEnd = start + i * 5 + 4;
			subEnd = (subEnd>end)?end:subEnd;
			int groupMedian = findKthNum(arr, subStart, subEnd, (subEnd - subStart + 2)>>1);
			tmpInt = arr[start + i]; arr[start + i] = arr[groupMedian]; arr[groupMedian] = tmpInt;
		}
		return findKthNum(arr, start, start + groupSize - 1, (groupSize + 1)/2);
	}

}
