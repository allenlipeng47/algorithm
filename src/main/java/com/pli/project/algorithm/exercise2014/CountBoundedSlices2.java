package com.pli.project.algorithm.exercise2014;

import java.util.ArrayList;

public class CountBoundedSlices2 {
	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 4, 5, 1, 6, 7, 9};
		countBoundedSlices(arr, 4);
	}
	
	public static void countBoundedSlices(int[] arr, int k){
		//initial maxQueue and minQueue.
		int front=0, end=1;
		BoundedSlicesSData frontElem = new BoundedSlicesSData(arr[front],front);
		BoundedSlicesSData endElem = new BoundedSlicesSData(arr[end],end);
		ArrayList<BoundedSlicesSData> maxQueue = new ArrayList<BoundedSlicesSData>();
		ArrayList<BoundedSlicesSData> minQueue = new ArrayList<BoundedSlicesSData>();
		addToMaxQueue(maxQueue, frontElem);
		addToMaxQueue(maxQueue, endElem);
		addToMinQueue(minQueue, frontElem);
		addToMinQueue(minQueue, endElem);
		//The following elements are recorded to check max-min<k
		BoundedSlicesSData maxElem = maxQueue.get(0);	//indicate the max element.
		BoundedSlicesSData minElem = minQueue.get(0);	//indicate the min element.
		for(;front<arr.length&&end+1<arr.length;front++){
			//delete elements from front which has position less than front.
			while(maxElem.position<front){
				maxQueue.remove(0);
				maxElem = maxQueue.get(0);
			}
			while(minElem.position<front){
				minQueue.remove(0);
				minElem = minQueue.get(0);
			}
			//move end forward until max-min<k
			while(front<arr.length&&end+1<arr.length&&((maxElem.value-minElem.value<k)||front==end)){
				end++;
				endElem = new BoundedSlicesSData(arr[end], end);
				addToMaxQueue(maxQueue, endElem);
				addToMinQueue(minQueue, endElem);
				maxElem = maxQueue.get(0);
				minElem = minQueue.get(0);
			}
			if(front!=end-1){
				System.out.println("("+front+","+(end-1)+")");
			}
			if(end==arr.length-1){	//to get the last result
				System.out.println("("+front+","+end+")");
			}
		}
	}
	
	/*
	 * Add a new element to min queue. Keep the min quene with ascend sequence.
	 */
	public static void addToMinQueue(ArrayList<BoundedSlicesSData> queue, BoundedSlicesSData newElement){
		if(queue.size()==0){
			queue.add(newElement);
			return;
		}
		BoundedSlicesSData front = queue.get(0);
		if(newElement.value<front.value){	//new element is smaller than the front. Clear queue and add it.
			queue.clear();
			queue.add(newElement);
			return;
		}
		BoundedSlicesSData end = queue.get(queue.size()-1);
		 /* Or delete those elements which are larger than new element from end of queue.
		 * And add new element to the queue. */
		while(end.value>=newElement.value){	
			queue.remove(queue.size()-1);	
			end = queue.get(queue.size()-1);
		}
		queue.add(newElement);
	}
	
	/*
	 * Add a new element to max queue. Keep the min quene with descend sequence.
	 */
	public static void addToMaxQueue(ArrayList<BoundedSlicesSData> queue, BoundedSlicesSData newElement){
		if(queue.size()==0){
			queue.add(newElement);
			return;
		}
		BoundedSlicesSData front = queue.get(0);
		if(newElement.value>front.value){	//new element is larger than the front. Clear queue and add it.
			queue.clear();
			queue.add(newElement);
			return;
		}
		BoundedSlicesSData end = queue.get(queue.size()-1);
		 /* Or delete those elements which are less than new element from end of queue.
		 * And add new element to the queue. */
		while(end.value<=newElement.value){	
			queue.remove(queue.size()-1);	
			end = queue.get(queue.size()-1);
		}
		queue.add(newElement);
	}
	
}

