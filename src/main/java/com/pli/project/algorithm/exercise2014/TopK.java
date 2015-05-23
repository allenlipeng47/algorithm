package com.pli.project.algorithm.exercise2014;

/*
 * 用堆来求前k个最大值
 */
public class TopK {
	
	public static void main(String[] args) {
		int[] array = {5, 13,10,12,15,11, 8,23, 40, 16, 83, 23, 31, 73, 59, 25, 75};
		findTopK(array, 5);
	}
	
	public static void findTopK(int[] array, int k){
		int[] heap = new int[k+1];
		heap[0] = k;
		for(int i=0;i<array.length;i++){
			heapPut(heap, array[i]);
		}
		printArray(heap);
	}
	
	/*
	 * 小顶堆，将value放在heap的第pos的位置上
	 */
	public static void heapPut(int[] heap, int value){
		if(heap==null){
			return;
		}
		if(value>heap[1]){
			heap[1] = value;
			heapAdjust(heap, 1);
		}
	}
	
	//调整第i位置
	public static void heapAdjust(int[] heap, int pos){
		if(heap==null||pos*2>heap[0]){	//堆为空，或调整位置不正确
			return;
		}
		if(heap[pos]<=heap[pos*2]&&(heap[0]==pos*2||heap[pos]<=heap[pos*2+1])){	//当前pos已是最小值，不需要调整
			return;
		}
		int minPos = (heap[0]==pos*2)?pos*2:heap[pos*2]<heap[pos*2+1]?pos*2:pos*2+1;	//pos位置的值不是最小，需要调整
		arrayExchange(heap, pos, minPos);
		heapAdjust(heap, minPos);
	}
	
	//在array数组中，交换pos1, pos2的值
	public static void arrayExchange(int[] array, int pos1, int pos2){
		if(array==null||pos1>array.length-1||pos2>array.length-1){
			return;
		}
		int tmp = array[pos1];	array[pos1] = array[pos2]; array[pos2] = tmp;
		return;
	}
	
	public static void printArray(int[] array){
		if(array==null){
			return;
		}
		for(int i=1;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}

}
