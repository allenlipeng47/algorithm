package com.pli.project.algorithm.exercise2014;

public class MinSublist {
	
	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5,4,2,3,7,8,6,9};
		int[] arr2 = {1,2,3,4,5,8,2,3,7,9,8};
		int[] arr3 = {1,5,2,6,5,4,3,8,6,7,8};
		int[] arr4 = {1,5,2,6,5,4,3,8,4,6,5,8};
		int[] arr5 = {1,2,3,5,8,2,2,3,2,7,9};
		int[] arr6 = {1,2,3,5,4,3,3,7,8,9};
		int[] arr7 = {1,2,3,4,5,6,7,4,3,6,5,6,7,8,9};
		int[] arr8 = {7,8,9,1,2,3};
		int[] arr = arr8;
		findMinSublist(arr);
	}
	
	public static void findMinSublist(int[] arr){
		Bound bound = findBound(arr);
		printArray(arr, 0, arr.length-1);
		MaxMinPos maxMin = findMaxMinPos(arr, bound.left_bound+1, bound.right_bound-1);
		int left = getLeftPos(arr, arr[maxMin.min], bound.left_bound);
		int right = getRightPos(arr, arr[maxMin.max], bound.right_bound);
		System.out.println("("+left+","+right+")");
	}
	
	/*
	 * This function return a left_bound, right_bound of the arr[], where arr[0,...,left_bound], arr[right_bound,...,len-1] are ascend.
	 * And arr[left_bound] is less than arr[right_bound].
	 * The idea is to find the right value in left and right side to compare. If left_compare is larger than right_compare, we found the boundes, and stop.
	 * If left_bound is found, then we should always use arr[left_bound] to compare.
	 * If right_bound is found, then we should always use arr[right_bound] to compare.
	 * This function should pass the below cases:
	 * int[] arr1 = {1,2,3,4,5,4,2,3,7,8,6,9};
	 * int[] arr2 = {1,2,3,4,5,8,2,3,7,8,6,9};
	 * int[] arr3 = {1,5,2,6,5,4,3,8,6,7,8,9};
	 * int[] arr4 = {1,5,2,6,5,4,3,8,4,6,7,8,9};
	 * int[] arr5 = {1,2,3,5,8,2,7,6,5,2,3,4,7,9};
	 */
	public static Bound findBound(int[] arr){
		if(arr==null||arr.length<2){
			return null;
		}
		int left_bound = 0, right_bound = arr.length-1;
		boolean found_left = false, found_right = false;
		while(left_bound<right_bound){
			int left_compare, right_compare;
			if(!found_left){
				if(arr[left_bound+1]<arr[left_bound]){	//if left_bound is found
					found_left = true;
					left_compare = arr[left_bound];
				}
				else{
					left_compare = arr[left_bound+1];	//if not, current comparison is arr[left_bound+1]
				}
			}
			else{
				left_compare = arr[left_bound];	//already found, left_compare is the left_bound value.
			}
			if(!found_right){
				if(arr[right_bound-1]>arr[right_bound]){	//if right_bound is found
					found_right = true;
					right_compare = arr[right_bound];
				}
				else{
					right_compare = arr[right_bound-1];	//if not, current comparison is arr[right_bound-1]
				}
			}
			else{
				right_compare = arr[right_bound];	//already found, right_compare is the right_bound value.
			}
			if(found_left&&found_right||left_compare>right_compare){	//check if left, right bound are both found.
				break;
			}
			if(!found_left){
				left_bound++;	//not found, move left_bound.
			}
			if(!found_right){
				right_bound--;	//not found, move right_bound.
			}
		}
		return new Bound(left_bound, right_bound);
	}
	
	/*
	 * Find the max, min pos in arr[]
	 */
	public static MaxMinPos findMaxMinPos(int[] arr, int start, int end){
		int max_pos = arr[start], min_pos = arr[start];
		for(int i=start;i<=end;i++){
			if(arr[i]<arr[min_pos]){
				min_pos = i;
			}
			if(arr[i]>arr[max_pos]){
				max_pos = i;
			}
		}
		return new MaxMinPos(max_pos, min_pos);
	}
	
	/*
	 * Get the left position for final result.
	 */
	public static int getLeftPos(int[] arr, int value, int end){
		int i;
		for(i=0;i<=end;i++){
			if(arr[i]>value){
				break;
			}
		}
		return i;
	}
	
	/*
	 * Get the right position for final result.
	 */
	public static int getRightPos(int[] arr, int value, int start){
		int i;
		for(i=arr.length-1;i>=start;i--){
			if(arr[i]<value){
				break;
			}
		}
		return i;
	}
	
	public static void printArray(int[] arr, int start, int end){
		for(int i=start;i<=end;i++){
			System.out.print(arr[i]);
		}
		System.out.println();
	}
	
	public static void printArray2(int[] arr, int left, int right){
		for(int i=0;i<=left;i++){
			System.out.print(arr[i]);
		}
		System.out.print(" ");
		for(int i=left+1;i<=right-1;i++){
			System.out.print(arr[i]);
		}
		System.out.print(" ");
		for(int i=right;i<=arr.length-1;i++){
			System.out.print(arr[i]);
		}
		System.out.println();
	}


//	/*
//	 * This function return the first position i in a sorted arr[start,...,end], where value is larger than arr[start,...,i-1]
//	 * For example, for (arr=[1,3,5,7,9], value=4, start=0, end=4), return 2.
//	 * For (arr=[1,3,3,5,7,9], value=3, start=0, end=4), it returns 3.
//	 * For (arr=[3,3,5,7,9], value=1, start=1, end=4), it returns 1.
//	 * For (arr=[3,3,5,7,9], value=10, start=0, end=3), it returns 3.
//	 * If value is less than all arr[start,...,end], return start.
//	 * If value is larger than all arr[start,...,end], return end.
//	 */
//	public static int findLeftPos(int[] arr, int value,  int start, int end){
//		if(arr==null||end-start<1){
//			return -1;
//		}
//		return findLeftPosUtil(arr, value, start, end, start, end);
//	}
//	
//	public static int findLeftPosUtil(int[] arr, int value, int original_start, int original_end, int start, int end){
//		int mid = (start+end)/2;
//		if(mid<=original_start){
//			if(mid==original_start&&value>=arr[mid]&&value<arr[mid+1]){
//				return mid+1;	//check boundary value
//			}
//			return original_start;
//		}
//		if(mid>=original_end){
//			return original_end;
//		}
//		if(value>=arr[mid-1]&&value<arr[mid]){
//			return mid;
//		}
//		if(value<arr[mid]){
//			return findLeftPosUtil(arr, value, original_start, original_end, start, mid-1);
//		}
//		else{
//			return findLeftPosUtil(arr, value, original_start, original_end, mid+1, end);
//		}
//	}
//	
//	/*
//	 * This function return the first position i in a sorted arr[start,...,end], where value is larger less arr[i+1,...,right]
//	 * For example, for (arr=[1,3,5,7,9], value=4, start=0, end=4), return 1.
//	 * For (arr=[1,2,3,5,5,7,9], value=5, start=0, end=6), it returns 2.
//	 * For (arr=[3,3,5,7,9], value=4, start=2, end=4), it returns 2.
//	 * For (arr=[3,3,5,7,9], value=10, start=0, end=3), it returns 3.
//	 * If value is less than all arr[start,...,end], return start.
//	 * If value is larger than all arr[start,...,end], return end.
//	 */
//	public static int findRightPos(int[] arr, int value,  int start, int end){
//		if(arr==null){
//			return -1;
//		}
//		return findRightPosUtil(arr, value, start, end, start, end);
//	}
//	
//	public static int findRightPosUtil(int[] arr, int value, int original_start, int original_end, int start, int end){
//		int mid = (start+end)/2;
//		if(mid<=original_start){
//			return original_start;
//		}
//		if(mid>=original_end){
//			return original_end;
//		}
//		if(value<=arr[mid+1]&&value>arr[mid]){
//			return mid;
//		}
//		if(value<=arr[mid]){
//			return findRightPosUtil(arr, value, original_start, original_end, start, mid-1);
//		}
//		else{
//			return findRightPosUtil(arr, value, original_start, original_end, mid+1, end);
//		}
//	}
}

class Bound{
	int left_bound;
	int right_bound;
	public Bound(int left_bound, int right_bound){
		this.left_bound = left_bound;
		this.right_bound = right_bound;
	}
}

class MaxMinPos{
	int max;
	int min;
	public MaxMinPos(int max, int min){
		this.max = max;
		this.min = min;
	}
	public String toString(){
		return "("+max+","+min+")";
	}
}