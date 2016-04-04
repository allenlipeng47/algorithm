package com.pli.project.algorithm.exercise2014;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CountBoundedSlices {
	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 4, 5, 1, 6, 7, 9};
		countBoundedSlices(arr, 2);
	}
	
	public static void countBoundedSlices(int[] arr, int k){
		BoundedSlicesSData curr = new BoundedSlicesSData(arr[0],0);
		ArrayList<BoundedSlicesSData> queue = new ArrayList<BoundedSlicesSData>();
		queue.add(curr);
		for(int i=1;i < arr.length;i++){
			curr = new BoundedSlicesSData(arr[i], i);
			queue.add(curr);
			Collections.sort(queue, new BoundedSlicesSDataComparator());	//add current element into queue.
			BoundedSlicesSData front = queue.get(0);
			BoundedSlicesSData end = queue.get(queue.size()-1);
			if(end.value-front.value>k&&curr.value==end.value){
				//Got a larger val at queue end. It makes max-min>k. So modify the queue front.
				while(end.value-front.value>k){
					int front_time = front.position;
					queue.remove(0);
					front = queue.get(0);
					while(front.position < front_time){	//delete those elements, which are earlier inserted than front
						queue.remove(0);
						front = queue.get(0);
					}//while
				}//while
				for(int j=0;j < queue.size()-1;j++){
					printResult(queue.get(j).position, end.position);
				}
			}
			else if(end.value-front.value>k&&curr.value==front.value){
				//Got a smaller val at queue front. It makes max-min>k. So modify the queue end.
				while(end.value-front.value>k){
					int end_time = end.position;
					queue.remove(queue.size()-1);
					end = queue.get(queue.size()-1);
					while(end.position < end_time){	//delete those elements, which are earlier inserted than front
						queue.remove(queue.size()-1);
						end = queue.get(queue.size()-1);
					}//while
				}//while
				for(int j=queue.size()-1;j>0;j--){
					printResult(queue.get(j).position, front.position);
				}
			}//if
			else{
				//insertation of curr doesn't affect max, min. Print result with curr
				for(int j=0;j < queue.size();j++){
					BoundedSlicesSData printAux = queue.get(j);
					if(printAux.position==curr.position){
						continue;
					}
					printResult(printAux.position, curr.position);
				}
			}//if
		}//for
	}
	
	public static void printResult(int i, int j){
		if(i < j){
			System.out.println("("+i+","+j+")");
		}
		else{
			System.out.println("("+j+","+i+")");
		}
	}
}

/*
 * The queue should store both val and position. So create this class for convinent.
 */
class BoundedSlicesSData{
	int value;
	int position;
	public BoundedSlicesSData(){}
	public BoundedSlicesSData(int value, int position){
		this.value = value;
		this.position = position;
	}
}

/*
 * help to sort the BoundedSlicesSData queue
 */
class BoundedSlicesSDataComparator implements Comparator < BoundedSlicesSData>{
	public int compare(BoundedSlicesSData b1, BoundedSlicesSData b2){
		return b1.value - b2.value;
	}
}