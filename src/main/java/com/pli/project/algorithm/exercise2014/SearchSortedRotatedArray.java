package com.pli.project.algorithm.exercise2014;

public class SearchSortedRotatedArray {
	
	public static void main(String[] args) {
		int[] array = {3, 4, 5, 6, 7, 1, 2};
		System.out.println(findNumInSortedRotatedArray(array, 6, 0, array.length-1));
	}
	
	/**
	 * http://stackoverflow.com/questions/4773807/searching-in-an-sorted-and-rotated-array
	 */
	public static int findNumInSortedRotatedArray(int[] array, int key, int low, int high){
		int mid = (low + high) / 2;
		if(array[mid]==key){
			return mid;
		}
		if(array[low]<=array[mid]){
			//◊Û±ﬂ”––Ú	3 4 5 6 7 1 2
			if(array[low]<=key&&array[mid]>=key){
				return findNumInSortedRotatedArray(array, key, low, mid);
			}
			else{
				return findNumInSortedRotatedArray(array, key, mid+1, high);
			}
		}
		else{
			//”“±ﬂ”––Ú	6 7 1 2 3 4 5 
			if(array[mid]<=key&&array[high]>=key){
				return findNumInSortedRotatedArray(array, key, mid, high);
			}
			else{
				return findNumInSortedRotatedArray(array, key, low, mid-1);
			}
		}
	}

}
